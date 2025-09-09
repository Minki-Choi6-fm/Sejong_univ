#include <WiFi.h>          // ESP32 Wi-Fi 라이브러리
#include <ThingSpeak.h>    // ThingSpeak 클라우드 플랫폼 통신 라이브러리
#include <Servo.h>         // 서보 모터 제어 라이브러리
#include "HX711.h"         // 로드셀 앰프 HX711 라이브러리
#include <MFRC522.h>       // RFID 리더 RC522 라이브러리
#include <SPI.h>           // RC522는 SPI 통신을 사용하므로 SPI 라이브러리 포함
#include <Ultrasonic.h>    // 초음파 센서 라이브러리 추가

// ==== Wi-Fi 설정 ====
const char* ssid = "본인의_와이파이_SSID";        // 접속할 Wi-Fi 네트워크 이름
const char* password = "본인의_와이파이_비밀번호";      // 접속할 Wi-Fi 비밀번호

// ==== ThingSpeak 설정 ====
unsigned long myChannelNumber = 본인의_채널_번호; // ThingSpeak 채널 ID (숫자)
const char* myWriteAPIKey = "본인의_쓰기_API_키";     // ThingSpeak 채널 쓰기 API 키 (문자열)

// ThingSpeak 필드 번호 정의 (ThingSpeak 채널 설정에서 확인/변경)
const int TS_FIELD_RFID = 1;   // 필드 1에 RFID 사용자 ID를 보낼 예정 (숫자 형태)
const int int TS_FIELD_WEIGHT = 2; // 필드 2에 쓰레기 무게를 보낼 예정 (숫자 형태)

WiFiClient client; // Wi-Fi 클라이언트 객체 생성

// ==== 핀 정의 (ESP32 예시 핀 번호 - **실제 연결에 맞게 수정하세요!**) ====
// 모터 제어 핀 (L298N 드라이버 사용 가정)
// L298N의 IN1, IN2, IN3, IN4는 모터 회전 방향/정지 제어
// L298N의 ENA, ENB는 모터 속도 제어 (PWM 핀 사용)
const int MOTOR_LEFT_IN1 = 13; // 왼쪽 모터 IN1
const int MOTOR_LEFT_IN2 = 12; // 왼쪽 모터 IN2
const int MOTOR_LEFT_EN = 26;  // 왼쪽 모터 ENA (PWM 가능 핀)

const int MOTOR_RIGHT_IN3 = 14; // 오른쪽 모터 IN3
const int MOTOR_RIGHT_IN4 = 27; // 오른쪽 모터 IN4
const int MOTOR_RIGHT_EN = 25; // 오른쪽 모터 ENB (PWM 가능 핀)

// 라인 센서 핀 (2개 사용 가정)
// 아날로그 센서 값을 읽을 ESP32 아날로그 핀 (ADC1 핀 권장)
const int LINE_SENSOR_LEFT = 34; // 왼쪽 라인 센서 (예: ESP32 ADC1 핀)
const int LINE_SENSOR_RIGHT = 35; // 오른쪽 라인 센서 (예: ESP32 ADC1 핀)

// ==== 초음파 센서 핀 정의 (ESP32 예시 핀 번호 - **실제 연결에 맞게 수정하세요!**) ====
const int ULTRASONIC_TRIG_PIN = 17; // 초음파 센서 Trig 핀
const int ULTRASONIC_ECHO_PIN = 18; // 초음파 센서 Echo 핀
Ultrasonic ultrasonic(ULTRASONIC_TRIG_PIN, ULTRASONIC_ECHO_PIN);

// ==== 센서 임계값 설정 ====
int line_threshold = 500;
int obstacle_distance_threshold = 30; // 장애물 감지 거리 임계값 (cm) - **실제 환경에 맞게 조정 필요!**

// 서보 모터 핀
const int SERVO_PIN = 16; // 서보 모터 신호 핀 (PWM 가능 핀)

// HX711 로드셀 앰프 핀
const int HX711_DOUT = 4; // HX711 DOUT 핀 (데이터 출력)
const int HX711_SCK = 2;  // HX711 SCK 핀 (클럭 입력)

// MFRC522 RFID 리더 핀 (SPI 통신 사용)
const int MFRC522_SS = 5;  // MFRC522 SS (Slave Select) 핀 - ESP32의 SS 핀에 연결
const int MFRC522_RST = 22; // MFRC522 RST 핀 (리셋, 연결 필수)

// ==== 센서 임계값 설정 ====
// 라인 센서가 검은색 라인과 흰색 바닥을 구분하는 기준 값
// **실제 환경에서 시리얼 모니터로 센서 값을 확인하며 보정 필수!**
// 일반적으로 검은 라인에서 낮고, 밝은 바닥에서 높습니다 (반사광 센서 기준)
int line_threshold = 500; // 예시 값. 센서 종류 및 바닥 재질에 따라 크게 달라짐

// ==== 서보 각도 설정 ====
// 쓰레기통 뚜껑의 닫혔을 때와 열렸을 때의 서보 모터 각도
// **실제 서보 부착 상태를 확인하며 정확한 각도 설정 필요!**
int lid_closed_angle = 0;  // 뚜껑 닫힘 각도 (0도 근처)
int lid_open_angle = 90;   // 뚜껑 열림 각도 (90도 근처)

// ==== 무게 측정 설정 ====
// **HX711 캘리브레이션 팩터!** 정확한 무게 측정을 위해 **반드시 보정해야 합니다!**
// 보정 방법:
// 1. setup() 함수에서 scale.tare() 호출 후 빈 저울 상태에서 시리얼 모니터로 scale.get_value() 값을 확인합니다.
// 2. 저울 위에 알려진 무게(예: 100g 추)를 올리고 다시 scale.get_value() 값을 확인합니다.
// 3. (추를 올렸을 때 get_value 값) - (빈 저울 get_value 값) = Raw_Value_Diff
// 4. calibration_factor = Raw_Value_Diff / 알려진_무게(100g)
// 5. 계산된 calibration_factor 값을 여기에 입력합니다. 부호(+/-)도 중요합니다.
float calibration_factor = -22000; // **예시 값, 실제 보정 필수!** 부호 주의!
float initial_weight = 0.0; // 쓰레기 투입 전 무게 저장 변수
float final_weight = 0.0;   // 쓰레기 투입 후 무게 저장 변수
float trash_weight = 0.0;   // 계산된 쓰레기 무게 저장 변수

// ==== 타이머 변수 ====
unsigned long lid_open_timer = 0; // 뚜껑 열림 상태 시간 측정을 위한 타이머
const unsigned long LID_OPEN_DURATION = 5000; // 뚜껑 열림 유지 시간 (밀리초 단위, 5000ms = 5초)
unsigned long state_timer = 0; // 각 상태 진입 시 시작되어 상태 전환이나 대기 시간에 사용될 타이머
const unsigned long WEIGHT_STABILIZE_DURATION = 2000; // 무게 측정 전 센서 안정화 대기 시간 (2초)

// ==== 상태 머신 변수 ====
// 시스템의 현재 동작 상태를 나타내는 열거형 변수
enum SystemState {
  STATE_LINE_FOLLOWING,
  STATE_STOPPED_OBSTACLE_DETECTED, // 장애물 감지되어 멈춘 상태 추가
  STATE_STOPPED_WAITING_RFID,     // (현재 코드에서는 RFID 감지가 바로 멈춤 트리거) 멈춰서 RFID를 기다리는 상태
  STATE_RFID_DETECTED,            // RFID 카드가 감지된 상태
  STATE_MEASURING_WEIGHT_BEFORE,  // 뚜껑 열기 전 무게 측정 상태
  STATE_OPENING_LID,              // 뚜껑 열리는 상태
  STATE_LID_OPEN_WAITING,         // 뚜껑이 열린 채 5초 대기하는 상태
  STATE_CLOSING_LID,              // 뚜껑 닫히는 상태
  STATE_MEASURING_WEIGHT_AFTER,   // 뚜껑 닫은 후 무게 측정 상태
  STATE_CALCULATING_AND_SENDING,  // 무게 계산 및 ThingSpeak 전송 상태
  STATE_RESUMING_MOVEMENT         // 움직임을 재개하는 상태
};
SystemState currentState = STATE_LINE_FOLLOWING; // 시스템 시작 시 초기 상태는 라인 추적

// ==== 전역 객체 생성 ====
Servo lidServo; // 서보 모터 제어를 위한 Servo 객체
HX711 scale;    // 로드셀 무게 측정을 위한 HX711 객체
MFRC522 mfrc522(MFRC522_SS, MFRC522_RST); // RFID 리더 MFRC522 객체 생성 (SS 핀, RST 핀)
String current_rfid_uid_str = ""; // 읽어온 RFID 카드 고유 번호(UID)를 문자열로 저장할 변수
byte current_rfid_uid_bytes[MFRC522::MAX_LEN]; // RFID UID 바이트 배열 저장
byte current_rfid_uid_size = 0; // RFID UID 크기 저장

// ==== 함수 선언 (Prototypes) ====
// 각 상태 및 특정 동작을 수행하는 헬퍼 함수들
void stopMotors();                            // 모터 정지
void moveForward(int speed);                  // 전진 (속도 조절)
void turnLeft(int speed);                     // 좌회전 (속도 조절)
void turnRight(int speed);                    // 우회전 (속도 조절)
void updateLineFollowing(int left_sensor_val, int right_sensor_val); // 라인 센서 값 기반 라인 추적 로직
void openLid();                               // 쓰레기통 뚜껑 열기
void closeLid();                              // 쓰레기통 뚜껑 닫기
float readStableWeight();                     // 안정적인 무게 값 읽기 (여러 번 측정 평균)
void connectWiFi();                           // Wi-Fi 네트워크 연결
bool readRFID();                              // RFID 카드 감지 및 UID 읽기 (새 카드 읽으면 true 반환)
unsigned long getRFIDasULong(byte* uid, byte uidSize); // RFID UID 바이트 배열을 ULong 숫자로 변환 (예시)
void transitionTo(SystemState nextState);     // 시스템 상태 전환 함수
long measureDistance();                       // 초음파 센서 거리 측정 함수

// ==== 초기 설정 함수 (setup) ====
void setup() {
  Serial.begin(115200); // 시리얼 통신 시작 (컴퓨터 시리얼 모니터로 디버깅 정보 확인)
  delay(100);
  Serial.println("스마트 쓰레기통 라인 트레이서 시작 중...");

  // 모터 제어 핀들을 출력 모드로 설정
  pinMode(MOTOR_LEFT_IN1, OUTPUT);
  pinMode(MOTOR_LEFT_IN2, OUTPUT);
  pinMode(MOTOR_LEFT_EN, OUTPUT);  // PWM 출력을 위해 OUTPUT 설정
  pinMode(MOTOR_RIGHT_IN3, OUTPUT);
  pinMode(MOTOR_RIGHT_IN4, OUTPUT);
  pinMode(MOTOR_RIGHT_EN, OUTPUT); // PWM 출력을 위해 OUTPUT 설정
  stopMotors(); // 시작 시 모터 정지

  // 라인 센서 핀들을 입력 모드로 설정 (아날로그 읽기 가능 핀)
  pinMode(LINE_SENSOR_LEFT, INPUT);
  pinMode(LINE_SENSOR_RIGHT, INPUT);

  //초음파 센서 초기화
  Serial.println("초음파 센서 초기화 중...");
  pinMode(ULTRASONIC_TRIG_PIN, OUTPUT);
  pinMode(ULTRASONIC_ECHO_PIN, INPUT);
  Serial.println("초음파 센서 준비 완료.");

  // 서보 모터 핀을 Servo 라이브러리에 연결
  lidServo.attach(SERVO_PIN);
  closeLid(); // 시스템 시작 시 뚜껑을 닫힌 상태로 설정

  // HX711 로드셀 앰프 초기화
  Serial.println("HX711 초기화 중...");
  scale.begin(HX711_DOUT, HX711_SCK); // HX711 핀 설정
  scale.set_scale(calibration_factor); // 무게 보정 계수 설정
  scale.tare(); // 저울의 현재 상태를 0점으로 설정 (빈 쓰레기통 상태에서 호출)
  Serial.println("HX711 준비 완료. 0점 조정됨.");

  // MFRC522 RFID 리더 초기화
  Serial.println("MFRC522 초기화 중...");
  SPI.begin();      // SPI 통신 버스 시작
  mfrc522.PCD_Init(); // MFRC522 리더 초기화
  Serial.println("MFRC522 준비 완료. RFID 카드를 스캔하세요.");

  // Wi-Fi 연결 시도
  connectWiFi();

  // ThingSpeak 라이브러리 초기화
  ThingSpeak.begin(client);

  // 시스템 초기 상태 설정
  transitionTo(STATE_LINE_FOLLOWING);
}

// ==== 메인 루프 함수 (loop) ====
// setup() 함수 실행 후 반복적으로 실행되는 함수
void loop() {
  // Wi-Fi 연결 상태 확인 및 필요 시 재연결
  if (WiFi.status() != WL_CONNECTED) {
    Serial.println("WiFi 연결 끊김. 재연결 시도...");
    connectWiFi();
  }

  // 상태 머신 구현: 현재 상태에 따라 다른 동작 수행
  switch (currentState) {
    case STATE_LINE_FOLLOWING: {
      // 라인 센서 값 읽기 (아날로그 값)
      long distance = measureDistance();
      Serial.print("장애물 거리: ");
      Serial.print(distance);
      Serial.println(" cm");

      if (distance <= obstacle_distance_threshold) {
        Serial.println("장애물 감지! 정지 후 RFID 대기.");
        stopMotors();
        transitionTo(STATE_STOPPED_OBSTACLE_DETECTED);
      } 
      else {
      // 라인 추적
      int left_sensor_val = analogRead(LINE_SENSOR_LEFT);
      int right_sensor_val = analogRead(LINE_SENSOR_RIGHT);
      updateLineFollowing(left_sensor_val, right_sensor_val);
      }
      break;
    }

    case STATE_STOPPED_OBSTACLE_DETECTED: {
      // RFID 카드 감지 확인 (멈춘 상태에서)
      if (readRFID()) {
        Serial.println("RFID 카드 감지됨!");
        transitionTo(STATE_RFID_DETECTED);
      }
      break;
    }

    case STATE_STOPPED_WAITING_RFID: {
        // 이 상태는 현재 라인 감지 로직에서 직접 사용되지 않지만,
        // 라인 이탈 등으로 멈추고 RFID를 기다리는 로직을 추가할 때 사용 가능
        // 현재는 RFID 감지가 STATE_LINE_FOLLOWING에서 바로 트리거됩니다.
        // 만약 이 상태를 사용한다면 여기에 RFID 감지 로직을 넣습니다.
        break; // STATE_STOPPED_WAITING_RFID 상태 종료
    }

    case STATE_RFID_DETECTED: {
        // readRFID() 함수에서 읽어온 RFID UID가 current_rfid_uid_str 변수에 저장되어 있습니다.
        Serial.print("감지된 RFID UID: ");
        Serial.println(current_rfid_uid_str);

        // 다음 RFID 스캔을 위해 RFID 리더 버퍼를 비워줍니다.
        mfrc522.PICC_HaltA();     // 현재 선택된 카드 비활성화
        mfrc522.PCD_StopCrypto1(0); // 암호화 해제

        // 다음 단계인 쓰레기 투입 전 무게 측정 상태로 전환
        transitionTo(STATE_MEASURING_WEIGHT_BEFORE);
        break; // STATE_RFID_DETECTED 상태 종료
    }

    case STATE_MEASURING_WEIGHT_BEFORE: {
        Serial.println("쓰레기 넣기 전 무게 측정 중...");
        stopMotors(); // 정확한 측정을 위해 모터 정지 확인

        // 무게 센서 값이 안정될 때까지 잠시 대기
        if (millis() - state_timer < WEIGHT_STABILIZE_DURATION) {
            Serial.print("."); // 대기 중임을 표시
            delay(100); // 시리얼 출력 과부하 방지를 위한 짧은 딜레이
        } else {
            // 무게 측정 및 저장
            initial_weight = readStableWeight();
            Serial.print("초기 무게: "); Serial.print(initial_weight); Serial.println(" g");
            // 다음 단계인 뚜껑 열기 상태로 전환
            transitionTo(STATE_OPENING_LID);
        }
        break; // STATE_MEASURING_WEIGHT_BEFORE 상태 종료
    }

    case STATE_OPENING_LID: {
      Serial.println("뚜껑 열기...");
      openLid(); // 뚜껑 열기 함수 호출
      lid_open_timer = millis(); // 뚜껑 열림 타이머 시작
      // 다음 단계인 뚜껑 열림 대기 상태로 전환
      transitionTo(STATE_LID_OPEN_WAITING);
      break; // STATE_OPENING_LID 상태 종료
    }

    case STATE_LID_OPEN_WAITING: {
      // 뚜껑 열림 유지 시간(LID_OPEN_DURATION) 동안 대기
      if (millis() - lid_open_timer >= LID_OPEN_DURATION) {
        Serial.println("5초 경과. 뚜껑 닫기.");
        // 대기 시간 경과 후 뚜껑 닫기 상태로 전환
        transitionTo(STATE_CLOSING_LID);
      }
      // (추가 기능: 대기 중 다시 RFID 스캔 시 5초 타이머 리셋 등 로직 추가 가능)
      break; // STATE_LID_OPEN_WAITING 상태 종료
    }

    case STATE_CLOSING_LID: {
      Serial.println("뚜껑 닫기...");
      closeLid(); // 뚜껑 닫기 함수 호출
      // 서보 모터가 닫히는 데 필요한 시간만큼 간단히 대기
      delay(1000); // 1초 대기 (서보 속도에 따라 조절)
      // 다음 단계인 쓰레기 투입 후 무게 측정 상태로 전환
      transitionTo(STATE_MEASURING_WEIGHT_AFTER);
      break; // STATE_CLOSING_LID 상태 종료
    }

    case STATE_MEASURING_WEIGHT_AFTER: {
        Serial.println("쓰레기 넣은 후 무게 측정 중...");
        stopMotors(); // 정확한 측정을 위해 모터 정지 확인

        // 무게 센서 값이 안정될 때까지 잠시 대기
        if (millis() - state_timer < WEIGHT_STABILIZE_DURATION) {
             Serial.print("."); // 대기 중임을 표시
             delay(100); // 시리얼 출력 과부하 방지를 위한 짧은 딜레이
        } else {
            // 무게 측정 및 저장
            final_weight = readStableWeight();
            Serial.print("최종 무게: "); Serial.print(final_weight); Serial.println(" g");
            // 다음 단계인 무게 계산 및 전송 상태로 전환
            transitionTo(STATE_CALCULATING_AND_SENDING);
        }
      break; // STATE_MEASURING_WEIGHT_AFTER 상태 종료
    }

    case STATE_CALCULATING_AND_SENDING: {
      // 쓰레기 무게 계산 (음수 방지 처리 - 센서 오차로 인해 발생 가능)
      trash_weight = final_weight - initial_weight;
      if (trash_weight < 0) {
         trash_weight = 0; // 무게는 음수가 될 수 없다고 가정
         Serial.println("경고: 계산된 무게가 음수입니다. 0으로 처리합니다.");
      }

      Serial.print("계산된 쓰레기 무게: "); Serial.print(trash_weight); Serial.println(" g");
      Serial.print("ThingSpeak로 데이터 전송 시도 - RFID UID: "); Serial.println(current_rfid_uid_str);

      // RFID UID를 ThingSpeak로 보내기 위해 숫자로 변환
      // ThingSpeak 필드가 숫자 타입일 때 필요합니다.
      // **주의:** RFID UID 바이트 배열을 숫자로 변환하는 방식은 고유 사용자 식별에 한계가 있을 수 있습니다.
      // 더 견고한 사용자 식별을 위해서는 별도의 사용자 ID 관리 및 매핑 로직이 필요할 수 있습니다.
      unsigned long rfid_numeric_id = getRFIDasULong(current_rfid_uid_bytes, current_rfid_uid_size);
      Serial.print("ThingSpeak 전송용 RFID 숫자 ID: "); Serial.println(rfid_numeric_id);


      // ThingSpeak에 데이터 전송 준비
      ThingSpeak.setField(TS_FIELD_RFID, rfid_numeric_id); // 필드 1에 RFID 숫자 ID 설정
      ThingSpeak.setField(TS_FIELD_WEIGHT, trash_weight); // 필드 2에 쓰레기 무게 설정

      // ThingSpeak로 데이터 전송 실행
      int httpCode = ThingSpeak.writeFields(myChannelNumber, myWriteAPIKey);

      // 전송 결과 확인
      if (httpCode == 200) {
        Serial.println("ThingSpeak 업데이트 성공.");
      } else {
        Serial.print("ThingSpeak 업데이트 실패. HTTP 에러 코드: ");
        Serial.println(httpCode); // 에러 코드 확인 (예: 400 Bad Request, 404 Not Found 등)
        // 에러 처리 로직 추가 가능 (예: 재시도, 알림 등)
      }

      // 다음 RFID 스캔을 위해 저장된 RFID 정보를 초기화
      current_rfid_uid_str = "";
      current_rfid_uid_size = 0; // UID 크기 초기화
      // MFRC522 내부 상태는 readRFID()에서 이미 정리됨

      // 모든 프로세스 완료 후 움직임 재개 상태로 전환
      transitionTo(STATE_RESUMING_MOVEMENT);
      break; // STATE_CALCULATING_AND_SENDING 상태 종료
    }

    case STATE_RESUMING_MOVEMENT: {
        Serial.println("라인 추적 움직임 재개.");
        // 재개에 필요한 추가적인 동작은 없으며, 다음 루프에서
        // STATE_LINE_FOLLOWING으로 전환되어 모터 제어가 시작됩니다.
        // 다음 상태인 라인 추적 상태로 전환
        transitionTo(STATE_LINE_FOLLOWING);
        break; // STATE_RESUMING_MOVEMENT 상태 종료
    }
  }

  // loop() 함수가 너무 빠르게 반복되는 것을 방지하기 위한 짧은 딜레이
  // 하지만 너무 긴 딜레이는 센서 읽기나 타이밍에 영향을 줄 수 있으므로 주의
  // delay(10); // 필요에 따라 조절하거나 제거

  // HX711은 내부적으로 대기(delay)가 포함될 수 있습니다.
  // loop 실행 속도가 문제가 된다면, 상태별 딜레이 및 센서 읽기 방식 최적화가 필요할 수 있습니다.
}

// ==== 헬퍼 함수 구현 ====

// 모터 정지 함수
void stopMotors() {
  analogWrite(MOTOR_LEFT_EN, 0);      // 왼쪽 모터 속도 0
  digitalWrite(MOTOR_LEFT_IN1, LOW);  // 왼쪽 모터 방향 설정 (정지)
  digitalWrite(MOTOR_LEFT_IN2, LOW);
  analogWrite(MOTOR_RIGHT_EN, 0);     // 오른쪽 모터 속도 0
  digitalWrite(MOTOR_RIGHT_IN3, LOW); // 오른쪽 모터 방향 설정 (정지)
  digitalWrite(MOTOR_RIGHT_IN4, LOW);
}

// 전진 함수
// speed: 모터 속도 (0-255, PWM 값)
void moveForward(int speed) {
  analogWrite(MOTOR_LEFT_EN, speed);
  digitalWrite(MOTOR_LEFT_IN1, HIGH); // 왼쪽 모터 전진 방향
  digitalWrite(MOTOR_LEFT_IN2, LOW);
  analogWrite(MOTOR_RIGHT_EN, speed);
  digitalWrite(MOTOR_RIGHT_IN3, HIGH); // 오른쪽 모터 전진 방향
  digitalWrite(MOTOR_RIGHT_IN4, LOW);
}

// 좌회전 함수
// speed: 모터 속도 (0-255, PWM 값)
// ** 로봇의 실제 회전 방식에 맞게 IN1/IN2, IN3/IN4 제어 수정 필요 **
// 예: 차동 회전 (한쪽 전진, 다른 쪽 후진) 또는 한쪽 멈춤, 다른 쪽 전진 등
void turnLeft(int speed) {
  analogWrite(MOTOR_LEFT_EN, speed);
  digitalWrite(MOTOR_LEFT_IN1, LOW); // 왼쪽 모터 정지 또는 후진 (로봇 구조에 따라)
  digitalWrite(MOTOR_LEFT_IN2, HIGH);
  analogWrite(MOTOR_RIGHT_EN, speed);
  digitalWrite(MOTOR_RIGHT_IN3, HIGH); // 오른쪽 모터 전진
  digitalWrite(MOTOR_RIGHT_IN4, LOW);
}

// 우회전 함수
// speed: 모터 속도 (0-255, PWM 값)
// ** 로봇의 실제 회전 방식에 맞게 IN1/IN2, IN3/IN4 제어 수정 필요 **
void turnRight(int speed) {
  analogWrite(MOTOR_LEFT_EN, speed);
  digitalWrite(MOTOR_LEFT_IN1, HIGH); // 왼쪽 모터 전진
  digitalWrite(MOTOR_LEFT_IN2, LOW);
  analogWrite(MOTOR_RIGHT_EN, speed);
  digitalWrite(MOTOR_RIGHT_IN3, LOW); // 오른쪽 모터 정지 또는 후진 (로봇 구조에 따라)
  digitalWrite(MOTOR_RIGHT_IN4, HIGH);
}

long measureDistance() {
  return ultrasonic.read(); // Ultrasonic 라이브러리의 read() 함수는 거리를 cm 단위로 반환합니다.
}

// 라인 센서 값에 기반한 라인 추적 로직 (2개 센서 기준)
// left_sensor_val: 왼쪽 라인 센서 아날로그 값
// right_sensor_val: 오른쪽 라인 센서 아날로그 값
void updateLineFollowing(int left_sensor_val, int right_sensor_val) {
    int base_speed = 150; // 라인 추적 기본 주행 속도 (0-255)
    int turn_speed = 180; // 라인 이탈 감지 시 회전 속도

    // 센서 값이 임계값보다 작으면 라인 위에 있다고 판단 (반사광 센서 가정)
    bool left_on_line = left_sensor_val < line_threshold;
    bool right_on_line = right_sensor_val < line_threshold;

    if (left_on_line && right_on_line) {
        // 양쪽 센서 모두 라인 위: 전진
        // Serial.println("라인 위: 전진");
        moveForward(base_speed);
    } else if (!left_on_line && right_on_line) {
        // 왼쪽 센서가 라인 벗어남: 왼쪽으로 회전하여 라인 되찾기
        // Serial.println("왼쪽 이탈: 좌회전");
        turnLeft(turn_speed);
    } else if (left_on_line && !right_on_line) {
        // 오른쪽 센서가 라인 벗어남: 오른쪽으로 회전하여 라인 되찾기
        // Serial.println("오른쪽 이탈: 우회전");
        turnRight(turn_speed);
    } else {
        // 양쪽 센서 모두 라인 벗어남: 라인을 잃어버림 (일단 정지 또는 탐색 로직 추가 필요)
        Serial.println("라인 이탈 감지: 정지");
        stopMotors();
        // 라인을 완전히 잃어버렸을 때의 추가적인 탐색 로직 또는 오류 처리 추가 필요
        // 필요 시 여기서 STATE_STOPPED_WAITING_RFID 또는 별도의 라인_탐색 상태로 전환
    }
}

// 쓰레기통 뚜껑 열기 함수
void openLid() {
  lidServo.write(lid_open_angle); // 설정된 열림 각도로 서보 이동
}

// 쓰레기통 뚜껑 닫기 함수
void closeLid() {
  lidServo.write(lid_closed_angle); // 설정된 닫힘 각도로 서보 이동
}

// 로드셀에서 안정적인 무게 값 읽기 함수
// 여러 번 읽어서 평균을 내어 측정치의 정확도를 높입니다.
// 반환 값: 안정화된 무게 값 (g)
float readStableWeight() {
    // 모터 정지 또는 뚜껑 닫힘 등 상태 변화 후 센서가 안정될 시간을 잠시 대기
    // delay(100); // 함수 호출 전에 충분히 대기했다면 생략 가능

    int num_readings = 10; // 평균 낼 측정 횟수
    float sum = 0; // 측정값들의 합계
    int stable_readings_count = 0; // 유효한(ready 상태인) 측정 횟수

    Serial.print("무게 측정 중... ");
    for (int i = 0; i < num_readings; i++) {
        // HX711이 다음 데이터를 읽을 준비가 될 때까지 최대 1초 대기
        if (scale.wait_ready_timeout(1000)) {
           sum += scale.get_units(); // 현재 설정된 스케일(calibration_factor)로 변환된 무게 값(단위: g)을 얻음
           stable_readings_count++; // 성공적으로 읽었으니 카운트 증가
           delay(50); // 각 측정 사이에 짧은 딜레이
        } else {
            Serial.println("경고: HX711 준비 안됨!");
            // 에러 처리: 특정 에러 값 반환, 이전 값 사용 또는 재시도 로직 추가 가능
        }
    }

    // 유효한 측정이 하나라도 있었다면 평균 계산, 아니면 0 또는 에러 값 반환
    if (stable_readings_count > 0) {
      float average_weight = sum / stable_readings_count;
      Serial.print("평균 무게: "); Serial.print(average_weight); Serial.println(" g");
      return average_weight;
    } else {
      Serial.println("오류: 무게를 읽을 수 없습니다.");
      return 0.0; // 또는 -999.0 등 에러를 나타내는 값 반환
    }
}

// Wi-Fi 네트워크 연결 함수
void connectWiFi() {
  Serial.print("Wi-Fi 연결 중");
  WiFi.begin(ssid, password); // 지정된 SSID와 비밀번호로 Wi-Fi 연결 시작

  // Wi-Fi 연결될 때까지 대기
  while (WiFi.status() != WL_CONNECTED) {
    delay(500); // 0.5초 간격으로 재시도
    Serial.print("."); // 연결 시도 중임을 표시
  }

  Serial.println(""); // 줄 바꿈
  Serial.println("Wi-Fi 연결 성공!");
  Serial.print("IP 주소: ");
  Serial.println(WiFi.localIP()); // 할당받은 로컬 IP 주소 출력
}

// RFID 카드 감지 및 UID 읽기 함수
// 새 카드가 감지되고 성공적으로 읽히면 true 반환, 그렇지 않으면 false 반환
bool readRFID() {
  // 새로운 RFID 카드가 리더기에 올라왔는지 확인
  if (mfrc522.PICC_IsNewCardPresent()) {
    // 감지된 카드 중 하나를 선택하여 UID(고유 번호)를 읽습니다.
    if (mfrc522.PICC_ReadCardSerial()) {
      // 카드가 성공적으로 감지되고 UID를 읽었습니다.

      // 읽어온 UID(바이트 배열)를 문자열 (Hex 형식)으로 변환하여 저장
      current_rfid_uid_str = ""; // 문자열 변수 초기화
      // mfrc522.uid.uidByte: UID 바이트 배열
      // mfrc522.uid.size: UID의 크기 (바이트)
      for (byte i = 0; i < mfrc522.uid.size; i++) {
        current_rfid_uid_str += (mfrc522.uid.uidByte[i] < 0x10 ? "0" : ""); // 16진수 한 자릿수일 경우 앞에 '0' 추가
        current_rfid_uid_str += String(mfrc522.uid.uidByte[i], HEX); // 바이트 값을 16진수 문자열로 변환하여 추가
      }
      current_rfid_uid_str.toUpperCase(); // 선택 사항: 16진수 문자열을 대문자로 변환

      // 읽어온 UID 바이트 배열과 크기도 별도의 변수에 저장 (숫자 변환 함수에서 사용)
      for (byte i = 0; i < mfrc522.uid.size; i++) {
         current_rfid_uid_bytes[i] = mfrc522.uid.uidByte[i];
      }
      current_rfid_uid_size = mfrc522.uid.size;


      Serial.print("카드 UID (Hex): ");
      Serial.println(current_rfid_uid_str);

      // (추가 기능: 이미 처리 중인 카드인지, 유효한 카드인지 등 확인 로직 추가 가능)

      return true; // 새로운 카드가 성공적으로 읽혔음을 알림
    }
  }
  return false; // 새로운 카드가 감지되지 않았거나 읽기 실패
}

// RFID UID 바이트 배열을 Unsigned Long 숫자로 변환하는 예시 함수
// **주의: 모든 길이의 UID에 대해 유일한 숫자를 보장하지 않습니다!**
// MFRC522는 4, 7, 10 바이트 등의 UID를 읽을 수 있습니다.
// 이 함수는 UID의 처음 최대 4바이트를 사용하여 ULong 숫자를 만듭니다.
// 사용자 식별용으로는 충돌 가능성이 있거나 별도의 매핑 시스템이 필요할 수 있습니다.
unsigned long getRFIDasULong(byte* uid, byte uidSize) {
    unsigned long number = 0;
    // ULong은 4바이트 크기이므로 UID의 처음 최대 4바이트까지만 사용합니다.
    int bytes_to_use = min((int)uidSize, 4); // UID 크기와 4바이트 중 작은 값 선택

    // 바이트들을 조합하여 ULong 숫자를 만듭니다. (Little-endian 방식)
    // 예를 들어, UID가 {0xAA, 0xBB, 0xCC, 0xDD} 이면 결과는 0xDDCCBBAA
    for (int i = bytes_to_use - 1; i >= 0; i--) {
        number <<= 8;       // 현재 숫자를 왼쪽으로 8비트 이동 (다음 바이트를 위한 공간 확보)
        number |= uid[i];   // 현재 바이트 값을 OR 연산으로 추가
    }
    return number; // 변환된 ULong 숫자 반환
}


// 시스템 상태를 다음 상태로 전환하는 함수
// nextState: 전환할 다음 상태 (SystemState 열거형 값)
void transitionTo(SystemState nextState) {
  currentState = nextState; // 현재 상태 업데이트
  state_timer = millis(); // 상태 전환 시간을 기록 (타이머 시작)

  // 시리얼 모니터에 상태 전환 정보 출력 (디버깅용)
  Serial.print("--- 상태 전환: ");
  switch (currentState) {
    case STATE_LINE_FOLLOWING: Serial.println("라인 추적 (STATE_LINE_FOLLOWING)"); break;
    case STATE_STOPPED_OBSTACLE_DETECTED: Serial.println("장애물 감지, 정지 (STATE_STOPPED_OBSTACLE_DETECTED)"); break;
    case STATE_RFID_DETECTED: Serial.println("RFID 감지됨 (STATE_RFID_DETECTED)"); break;
    case STATE_STOPPED_WAITING_RFID: Serial.println("정지, RFID 대기 (STATE_STOPPED_WAITING_RFID)"); break;
    case STATE_RFID_DETECTED: Serial.println("RFID 감지됨 (STATE_RFID_DETECTED)"); break;
    case STATE_MEASURING_WEIGHT_BEFORE: Serial.println("무게 측정 (투입 전) (STATE_MEASURING_WEIGHT_BEFORE)"); break;
    case STATE_OPENING_LID: Serial.println("뚜껑 열기 (STATE_OPENING_LID)"); break;
    case STATE_LID_OPEN_WAITING: Serial.println("뚜껑 열림 대기 (STATE_LID_OPEN_WAITING)"); break;
    case STATE_CLOSING_LID: Serial.println("뚜껑 닫기 (STATE_CLOSING_LID)"); break;
    case STATE_MEASURING_WEIGHT_AFTER: Serial.println("무게 측정 (투입 후) (STATE_MEASURING_WEIGHT_AFTER)"); break;
    case STATE_CALCULATING_AND_SENDING: Serial.println("무게 계산 및 전송 (STATE_CALCULATING_AND_SENDING)"); break;
    case STATE_RESUMING_MOVEMENT: Serial.println("움직임 재개 (STATE_RESUMING_MOVEMENT)"); break;
    default: Serial.println("알 수 없는 상태"); break;
  }
}