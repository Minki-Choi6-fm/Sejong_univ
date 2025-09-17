#include <stdio.h>
#include <stdlib.h>
#include <time.h>                               //헤더 선언

int *A, *B;                                     //전역 배열 선언

void inPlaceSelectionSort(int n, int *array) {  //inPlaceSelectionSort 함수
    int maxLoc;
    for (int i = n - 1; i > 0; i--) {           //뒤에서부터 교환시작
        maxLoc = i;
        for (int j = 0; j < i; j++) {           //앞에서부터 최댓값 탐색
            if (array[j] > array[maxLoc]) {
                maxLoc = j;                     //최댓값이 있으면 저장 뒤
            }
        }
        int tmp = array[i];
        array[i] = array[maxLoc];
        array[maxLoc] = tmp;                    //교환
    }
}

void inPlaceInsertionSort(int n, int *array) {  //inPlaceInsertionSort 함수
    int save, j;
    for (int i = 1; i < n; i++) {               //앞에서부터 교환 시작
        save = array[i];
        j = i - 1;                              //시작위치 배열변수 저장 뒤
        while ((j >= 0) && (array[j] > save)) { //저장 값보다 배열 값이 더 클 동안 반복
            array[j + 1] = array[j];
            j = j - 1;                          //뒤로 한칸씩 밀기
        }
        array[j + 1] = save;                    //빈 곳에 값 저장
    }
}

void reverseArray(int n,int *array){            //reverseArray 함수
    for(int i=0;i<n/2;i++){
        int tmp=array[i];
        array[i]=array[n-i-1];
        array[n-i-1]=tmp;                       //배열 뒤집기
    }
}

int main(void) {                                //main 함수
    int n;
    scanf("%d", &n);                            //반복횟수 입력

    A = (int *)malloc(sizeof(int) * n);
    B = (int *)malloc(sizeof(int) * n);         //동적할당

    srand((unsigned int)time(NULL));            //시간 기반의 난수 작동 시스템 구현
    
    for (int i = 0; i < n; i++) {
        int r_number = rand();
        A[i] = r_number;
        B[i] = r_number;                        //난수 배열에 저장
    }
    
    inPlaceSelectionSort(n, A);
    inPlaceSelectionSort(n, B);                 //배열 정순서 정렬(optional)
    reverseArray(n, A);
    reverseArray(n, B);                         //배열 뒤집기(optional)
    
    clock_t start, end;
    double insert, select;

    start = clock();
    inPlaceSelectionSort(n, A);
    end = clock();
    select = ((double)(end - start)) / CLOCKS_PER_SEC;  //제자리 선택 정렬 시간 계산
    printf("%fms\n", select);                   //제자리 선택 정렬 시간 출력

    start = clock();
    inPlaceInsertionSort(n, B);
    end = clock();
    insert = ((double)(end - start)) / CLOCKS_PER_SEC;  //제자리 선택 정렬 시간 계산
    printf("%fms\n", insert);                   //제자리 선택 정렬 시간 출력

    free(A);
    free(B);                                    //동적할당 해제
    
    return 0;
}
