#include <stdlib.h>
#include <stdio.h>                          //헤더 선언

int rSearch(int A[],int l,int r,int k){     //rSearch 함수
    if(r-l<0){                              //서로 역전되면(찾는 값이 없으면)
        if(r>=0){                           //더 작은 수 중 가장 큰 값이 있으면
            return r;                       //그 값 반환
        }
        else{                               //없으면
            return -1;                      //찾는 게 없으므로 -1 반환
        }
    }
    int mid=(l+r)/2;
    if(A[mid]==k){                          //가운데 값이 찾는 값이면
        return mid;                         //그 값 반환
    }
    else if(A[mid]<k){                      //가운데 값이 더 작으면
        return rSearch(A, mid+1, r, k);     //왼쪽만 이진 탐색
    }
    else{                                   //가운데 값이 더 크면
        return rSearch(A, l, mid-1, k);     //오른쪽 이진 탐색
    }
}

int main(void) {                            //main 함수
    int n,k;
    scanf("%d %d",&n,&k);                   //변수 입력
    int *A=(int*)malloc(sizeof(int)*n);     //배열 동적할당
    for(int i=0;i<n;i++){
        scanf("%d",&A[i]);                  //배열 입력
    }
    
    printf("%d",rSearch(A,0,n-1,k));        //함수 호출 및 출력
    return 0;                               //0 반환
}
