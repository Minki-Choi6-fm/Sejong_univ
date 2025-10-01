#include <stdio.h>

int n=0;
int H[100];                                 //힙 배열 및 개수 선언

void downHeap(int i,int size){              //downHeap 함수
    if(i*2>size){                           //자식이 없으면
        return;                             //반환 (베이스 케이스)
    }
    int bigger;
    
    if(i*2+1>size){                         //자식이 왼쪽만 있으면
        bigger=i*2;                         //왼쪽 자식이 제일 큼
    }
    else{                                   //둘 다 있으면
        bigger=H[i*2]<H[i*2+1]?i*2+1:i*2;   //비교 후 큰거 찾기
    }
    if(H[bigger]<H[i]){                     //이미 최대 힙 조건 만족시
        return;                             //반환(베이스 케이스)
    }
    int tmp=H[i];
    H[i]=H[bigger];
    H[bigger]=tmp;                          //부모 자식 서로 바꾸기
    downHeap(bigger,size);                  //자식 노드로 재귀 호출
}
void printHeap(void){                       //printHeap 함수
    for(int i=1;i<=n;i++){
        printf(" %d",H[i]);                 //레벨 순서로 출력
    }
    printf("\n");
}
void buildHeap(void){                       //buildHeap 함수
    for(int i=n/2;i>=1;i--){                //마지막 내부노드에서 루트까지 반복
        downHeap(i,n);                      //downHeap 호출로 정렬실행
    }
}
void inPlaceHeapSort(void){                 //inPlaceHeapSort 함수
    buildHeap();                            //힙 구조 만들고
    for(int i=n;i>1;i--){
        int tmp=H[1];
        H[1]=H[i];
        H[i]=tmp;
        downHeap(1,i-1);                    //한 칸씩 크기를 줄여가면서 힙 배열을 오름차순 배열로 정리
    }
}
int main(void) {                            //main 함수
    scanf("%d",&n);                         //개수 입력받기
    for(int i=1;i<=n;i++){
        scanf("%d",&H[i]);                  //정렬할 것들 입력받기
    }
    inPlaceHeapSort();                      //정렬 실행
    printHeap();                            //출력
    return 0;
}

