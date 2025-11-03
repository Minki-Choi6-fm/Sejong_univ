#include <string.h>
#include <stdlib.h>
#include <stdio.h>

typedef struct Node{
    int key;
    int status;                                     //status => 0일때는 empty, 1일때는 active, 2일때는 inactive상태
}Node;                                              //구조체 선언

void insert(Node *arr,int key,int M){               //insert 함수
    int i=0;
    int h=key%M;
    while(i<M){                                     //overflow 방지 조건
        if(arr[h].status==0){                       //빈 칸이면
            arr[h].key=key;
            arr[h].status=1;                        //넣고 상태 active로 바꾼뒤
            for(int j=0;j<i;j++){                   //충돌 횟수 출력
                printf("C");
            }
            printf("%d\n",h);                       //담긴 주소 출력
            return;
        }
        else{                                       //빈칸이 아니면
            i++;                                    //충돌횟수 1 증가
            h=(h+1)%M;                              //다음 칸으로 넘어가기
        }
    }
    return;
}
int search(Node *arr,int key,int M){                //search 함수
    int i=0;
    int h=key%M;
    while(i<M){                                     //overflow 방지 조건
        if(arr[h].status==0){                       //현재 보고 있는 칸이 점유된 적도 없으면
            return -1;                              //없는 것이므로 -1 반환
        }
        else if (arr[h].key==key){                  //찾는 값이면
            return h;                               //주소값 반환
        }
        else{                                       //찾는 값이 아니지만 다른 칸이 있을 수 있으면
            i++;                                    //충돌횟수 증가
            h=(h+1)%M;
        }
    }
    return -1;                                      //못 찾으면 -1 반환
}
int main(void) {                                    //main 함수
    int M,n;
    Node* HashTable;                                //해시테이블 선언
    scanf("%d %d",&M,&n);                           //해시테이블 크기 및 반복횟수 입력
    
    HashTable=(Node*)malloc(sizeof(Node)*M);        //해시 테이블 동적할당
    
    for(int i=0;i<M;i++){
        HashTable[i].status=0;                      //해시 테이블 상태 초기화
    }
    
    char c;
    int key;
    while(1){
        scanf("%c",&c);                             //실행할 활동 입력
        if(c=='i'){                                 //i 입력되면
            scanf("%d",&key);                       //키 입력
            insert(HashTable,key,M);                //함수 호출
        }
        if(c=='s'){                                 //s 입력되면
            scanf("%d",&key);                       //키 입력
            int s=search(HashTable,key,M);          //함수 호출
            printf("%d",s);
            if(s!=-1){
                printf(" %d\n",key);                //출력
            }
        }
        if(c=='e'){                                 //e 입력되면
            break;                                  //프로그램 종료
        }
    }

}
