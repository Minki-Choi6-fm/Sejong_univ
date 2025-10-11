#include <stdlib.h>
#include <stdio.h>

int Search(int A[],int n,int k){            //Search 함수
    int l=0;
    int r=n-1;                              //왼쪽,오른쪽 선언
    while(l<=r){                            //왼쪽 오른쪽 역전 전까지 반복(이진탐색)
        int mid=(l+r)/2;
        if(A[mid]==k){                      //가운데가 찾는 값이면
            return mid;                     //그 값 반환
        }
        else if(A[mid]<k){                  //가운데가 찾는 값보다 작으면
            l=mid+1;                        //오른쪽 부분 탐색
        }
        else{                               //가운데가 찾는 값보다 크면
            r=mid-1;                        //왼쪽 부분 탐색
        }
    }
    return l;                               //못 찾았으면 l 반환
}

int main(void) {                            //main 함수
    int n,k;
    scanf("%d %d",&n,&k);                   //변수 입력
    int *A=(int*)malloc(sizeof(int)*n);     //배열 동적할당
    for(int i=0;i<n;i++){
        scanf("%d",&A[i]);                  //배열 입력
    }
    
    printf("%d",Search(A,n,k));             //함수 호출 및 출력
    return 0;                               //0 반환
}
