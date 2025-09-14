#include <stdlib.h>
#include <stdio.h>                              //헤더 선언

void inPlaceInsertionSort(int n,int *array){    //inPlaceInsertionSort 함수
    int save,j;
    
    for(int i=1;i<n;i++){                       //2번째부터 끝까지 반복
        save=array[i];                          //시작위치 배열변수 저장 뒤
        j=i-1;
        while((j>=0)&&(array[j]>save)){         //저장 값보다 배열 값이 더 클 동안 반복
            array[j+1]=array[j];
            j=j-1;                              //뒤로 한칸씩 밀기
        }
        array[j+1]=save;                        //빈 자리에 넣기
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
    
    inPlaceInsertionSort(n, array);             //함수 호출
    return 0;
}

