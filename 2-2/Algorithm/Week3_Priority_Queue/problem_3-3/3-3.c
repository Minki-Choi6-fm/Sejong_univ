#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int *A, *B;

void inPlaceSelectionSort(int n, int *array) {
    int maxLoc;
    for (int i = n - 1; i > 0; i--) {
        maxLoc = i;
        for (int j = 0; j < i; j++) {
            if (array[j] > array[maxLoc]) {
                maxLoc = j;
            }
        }
        int tmp = array[i];
        array[i] = array[maxLoc];
        array[maxLoc] = tmp;
    }
}

void inPlaceInsertionSort(int n, int *array) {
    int save, j;
    for (int i = 1; i < n; i++) {
        save = array[i];
        j = i - 1;
        while ((j >= 0) && (array[j] > save)) {
            array[j + 1] = array[j];
            j = j - 1;
        }
        array[j + 1] = save;
    }
}

void reverseArray(int n,int *array){
    for(int i=0;i<n/2;i++){
        int tmp=array[i];
        array[i]=array[n-i-1];
        array[n-i-1]=tmp;
    }
}

int main(void) {
    int n;

    scanf("%d", &n);

    A = (int *)malloc(sizeof(int) * n);
    B = (int *)malloc(sizeof(int) * n);

    srand((unsigned int)time(NULL));
    for (int i = 0; i < n; i++) {
        int r_number = rand();
        A[i] = r_number;
        B[i] = r_number;
    }
    
    inPlaceSelectionSort(n, A);
    inPlaceSelectionSort(n, B);
    reverseArray(n, A);
    reverseArray(n, B);
    
    clock_t start, end;
    double insert, select;

    start = clock();
    inPlaceSelectionSort(n, A);
    end = clock();
    select = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("%fms\n", select);

    start = clock();
    inPlaceInsertionSort(n, B);
    end = clock();
    insert = ((double)(end - start)) / CLOCKS_PER_SEC;
    printf("%fms\n", insert);

    free(A);
    free(B);
    
    return 0;
}
