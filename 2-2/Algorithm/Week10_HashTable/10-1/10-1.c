#include <string.h>
#include <stdlib.h>
#include <stdio.h>

typedef struct Node{
    int key;
    struct Node* next;
    struct Node* prev;
}Node;                                              //구조체 선언

void insert(Node **arr,int key,int h){              //insert 함수
    Node* node=(Node*)malloc(sizeof(Node));         //새 노드 선언
    node->key=key;
    node->next=arr[h];                              //앞쪽에 삽입
    arr[h]=node;
}
int search(Node **arr,int key,int h){               //search 함수
    Node *node=arr[h];
    int count=1;
    while(node!=NULL){
        if(node->key==key){                         //찾는 키이면
            return count;                           //순서 반환
        }
        else{                                       //찾는 키가 아니면
            node=node->next;                        //다음거로 넘어가고
            count++;                                //순서 카운트 늘리기
        }
    }
    return 0;
}
int delete(Node **arr,int key,int h){               //delete 함수
    Node *node=arr[h];
    Node *target=node;                              //단일연결리스트라 이전 노드를 담아두기 위한 임시 노드 선언
    int count=1;
    while(node!=NULL){
        if(node->key==key){                         //키가 찾는 키이면
            if(node==arr[h]){                       //만약 맨 첫번째 경우인 경우
                arr[h]=node->next;
                free(node);
                return count;
            }
            else{                                   //첫번 째 아니면
                target->next=node->next;            //그 이전 노드를 다음 노드와 연결 후
                free(node);                         //메모리 해제
                return count;                       //count 반환
            }
        }
        else{                                       //찾는 키 아니면
            target=node;                            //이전 노드 업데이터
            node=node->next;                        //다음 노드로 넘어가기
            count++;                                //카운트 증가
        }
    }
    return 0;                                       //못 찾으면 0 반환
}
void print(Node **arr,int M){                       //print 함수
    for(int i=0;i<M;i++){
        Node *node=arr[i];
        while(node!=NULL){
            printf(" %d",node->key);                //각 해시테이블 순서대로 돌면서 출력
            node=node->next;
        }
    }
}
int main(void) {                                    //main 함수
    int M;
    Node** HashTable;                               //해시테이블을 이중 포인터로 선언
    scanf("%d",&M);                                 //해시테이블 크기 입력
    
    HashTable=(Node**)malloc(sizeof(Node*)*M);      //해시 테이블 동적할당
    
    for(int i=0;i<M;i++){
        HashTable[i]=NULL;                          //해시테이블 전체 NULL로 초기화
    }
    
    char c;
    int key,h;
    while(1){
        scanf("%c",&c);                             //실행할 활동 입력
        if(c=='i'){                                 //i 입력되면
            scanf("%d",&key);                       //키 입력
            h=key%M;
            insert(HashTable,key,h);                //함수 호출
        }
        if(c=='s'){                                 //s 입력되면
            scanf("%d",&key);                       //키 입력
            h=key%M;
            printf("%d\n",search(HashTable,key,h)); //함수 호출 후 반환값 출력
        }
        if(c=='d'){                                 //d 입력되면
            scanf("%d",&key);                       //키 입력
            h=key%M;
            printf("%d\n",delete(HashTable,key,h)); //함수 호출 후 반환값 출력
        }
        if(c=='p'){                                 //p 입력되면
            print(HashTable,M);                     //print 함수 실행
        }
        if(c=='e'){                                 //e 입력되면
            break;                                  //프로그램 종료
        }
    }

}
