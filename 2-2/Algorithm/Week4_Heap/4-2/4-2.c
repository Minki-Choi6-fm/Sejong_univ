#include <stdio.h>

int n=0;
int H[100];                                 //힙 배열 및 개수 선언

void downHeap(int i){                       //downHeap 함수
    if(i*2>n){                              //자식이 없으면
        return;                             //반환 (베이스 케이스)
    }
    int bigger;
    
    if(i*2+1>n){                            //자식이 왼쪽만 있으면
        bigger=i*2;                         //왼쪽 자식이 제일 큼
    }
    else{                                   //둘 다 있으면
        bigger=H[i*2]<H[i*2+1]?i*2+1:i*2;   //비교 후 큰 거 찾기
    }
    if(H[bigger]<H[i]){                     //이미 최대 힙 조건 만족시
        return;                             //반환(베이스 케이스)
    }
    int tmp=H[i];
    H[i]=H[bigger];
    H[bigger]=tmp;                          //부모 자식 서로 바꾸기
    downHeap(bigger);                       //자식 노드로 재귀 호출
}
void printHeap(void){                       //printHeap 함수
    for(int i=1;i<=n;i++){
        printf(" %d",H[i]);                 //레벨 순서로 출력
    }
    printf("\n");
}
void rBuildHeap(int i){                     //rBuildHeap 함수
    if(i>n){                                //범위롤 초과하면
        return;                             //반환(베이스 케이스)
    }
    rBuildHeap(2*i);
    rBuildHeap(2*i+1);                      //두 자식노드들 재귀 호출
    downHeap(i);                            //downHeap 호출로 정렬 실행
}
void buildHeap(void){                       //buildHeap 함수
    for(int i=n/2;i>=1;i--){                //마지막 내부노드에서 루트까지 반복
        downHeap(i);                        //downHeap 호출로 정렬실행
    }
}
int main(void) {                            //main 함수
    scanf("%d",&n);                         //개수 입력받기
    for(int i=1;i<=n;i++){
        scanf("%d",&H[i]);                  //정렬할 것들 입력받기
    }
    //rBuildHeap(1);
    buildHeap();                            //정렬 실행
    printHeap();                            //출력
    return 0;
}
