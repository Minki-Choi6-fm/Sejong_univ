#include <stdio.h>                          //헤더 파일 선언

int n=0;
int H[100];                                 //힙 배열 및 개수 선언

void upHeap(int i){                         //upHeap 함수
    if(i==1||H[i]<=H[i/2]){                 //루트 도달 또는 이미 조건 만족시
        return;                             //반환 (베이스 케이스)
    }
    int tmp=H[i];
    H[i]=H[i/2];
    H[i/2]=tmp;                             //부모와 교환 후
    upHeap(i/2);                            //부모 노드로 재귀 호출
}
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
void insertItem(int key){                   //insertItem 함수
    n++;                                    //힙 노드 개수 추가 후
    H[n]=key;                               //힙에 삽입
    upHeap(n);                              //upHeap 호출로 다시 힙 모양 정렬
}
int removeMax(void){                        //removeMax 함수
    int key=H[1];
    H[1]=H[n];                              //루트 추출 후 마지막 노드 넣기
    n--;                                    //힙 노드 개수 감소
    downHeap(1);                            //downHeap 호출로 다시 힙 모양 정렬
    return key;                             //원래 루트 노드 반환
}
void printHeap(void){                       //printHeap 함수
    for(int i=1;i<=n;i++){
        printf(" %d",H[i]);                 //레벨 순서로 출력
    }
    printf("\n");
}
int main(void) {                            //main 함수
    while(1){                               //무한반복
        char input;
        scanf("%c",&input);                 //입력받기
        if(input=='i'){                     //i 입력되면
            int key;
            scanf("%d",&key);               //입력값 받고
            insertItem(key);                //입력값 넣기
            printf("0\n");                  //0 출력
        }
        if(input=='d'){                     //d 입력되면
            printf("%d\n",removeMax());     //최댓값 출력
        }
        if(input=='p'&&n>0){                //p 입력되고 힙에 뭔가 있으면
            printHeap();                    //printHeap 호출
        }
        if(input=='q'){                     //q 입력되면
            break;                          //프로그램 종료
        }
    }
    return 0;
}
