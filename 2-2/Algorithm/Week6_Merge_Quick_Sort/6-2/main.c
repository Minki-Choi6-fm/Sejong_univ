#include <stdlib.h>
#include <stdio.h>
#include <time.h>                           //헤더 선언
    
int findPivot(int l,int r){                 //findPivot 함수
    int pivot=l+rand()%(r-l+1);
    return pivot;                           //난수로 pivot 무작위 지정 뒤 반환
}
void swap(int *a,int *b){                   //swap 함수
    int tmp=*a;
    *a=*b;
    *b=tmp;                                 //두 배열 요소 서로 교환
}
void inPlacePartition(int *arr,int l,int r,int k,int *a,int *b){    //inPlacePartion 함수
    int pivot=arr[k];                       //pivot 뽑아내고
    swap(&arr[k],&arr[r]);                  //맨 오른쪽으로 치워 둔 뒤 알고리즘 작동
    
    int less=l;
    int greater=r-1;
    int i=l;                                //pivot을 제외한 나머지 범위 탐색
    
    while(i<=greater){                      //전부 탐색시 종료
        if(arr[i]<pivot){                   //pivot보다 작은 요소면
            swap(&arr[i],&arr[less]);       //pivot보다 적은 그룹에 넣기 위해 less 그룹으로 보내기
            less++;                         //아까 그룹에 넣은건 제외하기 위해 1추가
            i++;                            //동일함
        }
        else if(arr[i]>pivot){              //pivot보다 큰 요소면
            swap(&arr[i],&arr[greater]);    //pivot보다 큰 구릅에 넣기 위해 greater 그룹으로 보내기
            greater--;                      //아까 그룹에 넣은건 제외하기 위해 1감소
        }
        else{                               //pivot과 같은 요소면
            i++;                            //탐색인자를 하나 넘겨주면서 less와 greater사이에 위치하도록 함
        }
    }
    swap(&arr[r],&arr[greater+1]);          //오른쪽으로 치워놨던 pivot 제자리 시키기
    
    *a = less;
    *b = greater + 1;                       //주소로 피벗 맨 왼쪽 오른쪽 요소 저장.
}

void inPlaceQuickSort(int *arr,int l,int r){    //inPlaceQuickSort 함수
    if(l>=r){                               //역전되면
        return;                             //반환
    }
    int a,b;                                //pivot의 맨 왼쪽 오른쪽 저장 변수
    int k=findPivot(l,r);                   //무작위로 pivot 지정 함수 호출
    inPlacePartition(arr,l,r,k,&a,&b);      //제자리 분할 함수 호출
    inPlaceQuickSort(arr, l, a-1);
    inPlaceQuickSort(arr, b+1, r);          //재귀 호출
}

int main(void) {                            //main 함수
    srand(time(NULL));                      //시간 기반 난수 함수 위해 선언
    int n;
    scanf("%d",&n);                         //배열 길이 입력
    
    int *arr=(int*)malloc(sizeof(int)*n);
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);                //동적할당 및 요소 입력
    }
    
    inPlaceQuickSort(arr, 0, n-1);          //quick sort 진행
    
    for(int i=0;i<n;i++){
        printf(" %d",arr[i]);               //출력
    }
    
    free(arr);                              //메모리 해제
    return 0;
}
