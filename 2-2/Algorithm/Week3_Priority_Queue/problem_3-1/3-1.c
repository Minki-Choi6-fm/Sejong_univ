#include <stdlib.h>
#include <stdio.h>                              //헤더 선언

void inPlaceSelectionSort(int n,int *array){    //inPlaceSelectionSort 함수
    int maxLoc;
    
    for(int i=n-1;i>0;i--){                     //뒤에서부터 교환시작
        maxLoc=i;
        for(int j=0;j<i;j++){                   //앞에서부터 최댓값 탐색
            if(array[j]>array[maxLoc]){
                maxLoc=j;                       //최댓값이 있으면 저장 뒤
            }
        }
        int tmp=array[i];
        array[i]=array[maxLoc];
        array[maxLoc]=tmp;                      //교환
    }
    for(int i=0;i<n;i++){
        printf(" %d",array[i]);                 //출력
    }
}

int main(void) {                                //main 함수
    int n;
    int *array;
    scanf("%d",&n);                             //배열 길이 입력
    
    array=(int*)malloc(sizeof(int)*n);          //배열 동적할당
    for(int i=0;i<n;i++){
        scanf("%d",&array[i]);                  //배열 값 입력
    }
    
    inPlaceSelectionSort(n, array);             //함수 호출
    return 0;
}
