#include <stdlib.h>
#include <stdio.h>

int findNum(int a,int b,int c){             //findNum 함수
    for(int i=0;i<c;i++){                   //c번 반복
        int mid=(a+b)/2;                    //가운데 값
        char ch;
        scanf("%c",&ch);                    //Y/N입력
        
        if(ch=='Y'){                        //가운데 값이 타겟보다 작으면
            a=mid+1;                        //오른쪽 탐색
        }
        if(ch=='N'){                        //더 크면
            b=mid;                          //왼쪽 탐색
        }
    }
    return a;                               //최종 값 반환
}
int main(void) {                            //main 함수
    int a,b,c;
    scanf("%d %d %d",&a,&b,&c);             //숫자 입력
    getchar();                              //개행 문자 제거
    
    printf("%d",findNum(a,b,c));            //출력
    return 0;                               //0 반환
}
