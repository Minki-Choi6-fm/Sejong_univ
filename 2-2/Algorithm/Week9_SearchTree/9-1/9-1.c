#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

typedef struct Node{
    struct Node *parent;
    int key;
    struct Node *lChild;
    struct Node *rChild;
}Node;                                      //구조체 선언

Node *root=NULL;                            //트리 루트 선언

bool isExternal(Node *w){                   //isExternal 함수
    if(w->lChild==NULL&&w->rChild==NULL){   //두 자식노드 다 null이면
        return true;                        //true 반환
    }
    else{                                   //아니면
        return false;                       //false 반환
    }
}

bool isInternal(Node *w){                   //isInternal 함수
    if(w->lChild==NULL&&w->rChild==NULL){   //두 자식노드 다 null이면
        return false;                       //false 반환
    }
    else{                                   //아니면
        return true;                        //true 반환
    }
}

bool isRoot(Node *z){                       //isRoot 함수
    if(z->parent==NULL){                    //부모가 없으면
        return true;                        //true 반환
    }
    else{                                   //있으면
        return false;                       //false 반환
    }
}

Node* treeSearch(Node *v,int key){          //treeSearch 함수
    if(isExternal(v)){                      //외부노드이면
        return v;                           //해당 노드 반환
    }
    if(key==v->key){                        //찾는 값이면
        return v;                           //해당 노드 반환
    }
    else if(key<v->key){                    //찾는 값이 더 작으면
        return treeSearch(v->lChild,key);   //왼쪽으로 내려가보기
    }
    else{                                   //더 크다면
        return treeSearch(v->rChild,key);   //오른쪽으로 내려가보기
    }
}

Node* inOrderSucc(Node *w){                 //inOrderSucc 함수
    w=w->rChild;                            //오른쪽 자식으로 옮긴 뒤
    
    if (isExternal(w)) {
        return NULL;                        //오른쪽 자식이 외부노드면 null반환 후 종료
    }
    
    while(isInternal(w->lChild)){           //오른쪽 자식의 왼쪽 자식 밑으로 쭉 내려가기
        w=w->lChild;
    }
    return w;                               //왼쪽 맨 끝 노드 반환
}

Node* sibling(Node *z){                     //sibling 함수
    if(isRoot(z)){
        return z;                           //루트 노드면 그냥 얘 반환
    }
    Node *w=z->parent;
    if(w->lChild==z){
        return w->rChild;
    }
    else{
        return w->lChild;                   //왼쪽 자식이면 오른쪽으로,오른쪽 자식이면 왼쪽으로 전환
    }
}

Node* reduceExternal(Node *z){              //reduceExternal 함수
    Node *w=z->parent;                      //노드의 부모 찾아 놓고
    Node *zs=sibling(z);                    //노드의 형제 찾아 놓고
    if(isRoot(w)){                          //만약 부모가 루트면
        root=zs;                            //형제를 루트로 올리기
        zs->parent=NULL;
    }
    else{                                   //부모가 루트가 아니면
        Node* g=w->parent;                  //부모의 부모를 찾은 뒤
        zs->parent=g;                       //아까 찾은 형제의 부모를 부모의 부모로 할당하고
        if(w==g->lChild){                   //부모가 왼쪽 자식 노드면
            g->lChild=zs;                   //부모의 부모의 왼쪽 자식을 형제 노드로 할당
        }
        else{                               //오른쪽 자식 노드면
            g->rChild=zs;                   //부모의 부모의 오른쪽 자식을 형제 노드로 할당
        }
    }
    free(z);
    free(w);                                //필요없는 메모리 해제
    return zs;                              //형제 노드 반환
}

void insertItem(int key){                           //insertItem 함수
    if(root==NULL){                                 //루트가 비어 있으면
        root = (Node*)malloc(sizeof(Node));
        root->parent = NULL;
        root->key = key;
        
        root->lChild = (Node*)malloc(sizeof(Node));
        root->lChild->parent = root;
        root->lChild->lChild = NULL;
        root->lChild->rChild = NULL;
        
        root->rChild = (Node*)malloc(sizeof(Node));
        root->rChild->parent = root;
        root->rChild->lChild = NULL;
        root->rChild->rChild = NULL;
        
        return;                                     //루트에 새 노드 할당해주고 종료
    }
    Node *w=treeSearch(root, key);                  //중복 있는지 확인 겸 새 노드 자리 찾기
    if(isInternal(w)){                              //삽입 위치가 내부노드면(중복 노드가 있으면)
        return;                                     //삽입 안하고 종료
    }
    else{                                           //중복이 없으면
        w->key = key;

        w->lChild = (Node*)malloc(sizeof(Node));
        w->lChild->parent = w;
        w->lChild->lChild = NULL;
        w->lChild->rChild = NULL;

        w->rChild = (Node*)malloc(sizeof(Node));
        w->rChild->parent = w;
        w->rChild->lChild = NULL;
        w->rChild->rChild = NULL;
        
        return;                                     //삽입 후 종료
    }
}
    
int removeElement(int k) {              //removeElement 함수
    Node *w = treeSearch(root, k);      //삭제할 노드 찾기
    if (isExternal(w)) {                //없으면
        return -1;                      //NoSuchKey 반환
    }

    int e = w->key;                     //삭제할 노드 키 값 받아놓기
    Node *z = w->lChild;                //삭제할 노드 왼쪽 노드 할당
    if (isInternal(z)) {                //해당 노드가 자식이 있다면
        z = w->rChild;                  //오른쪽 노드로 재할당
    }

    if (isExternal(z)) {                //자식이 0개 또는 1개이면
        reduceExternal(z);              //외부 더미 노드 줄이기
    }
    else {                              //자식이 2개이면
        Node *y = inOrderSucc(w);       //오른쪽 자식의 왼쪽밑으로 쭉 내려가기
        z = y->lChild;                  //y의 왼쪽 자식(외부 노드)
        w->key = y->key;                //y값을 w에 덮어 씌우고
        reduceExternal(z);              //z를 삭제
    }
    return e;                           //e를 반환
}

int findElement(int key){               //findElement 함수
    Node* node=treeSearch(root,key);    //해당하는 키를 가진 노드 찾기
    if(isExternal(node)){               //존재하지 않는다면
        return -1;                      //-1 반환
    }
    else{                               //존재한다면
        return node->key;               //해당 키 값 반환
    }
}

void preOrder(Node *n){                 //preOrder 함수
    if(isInternal(n)){                  //해당 노드가 내부노드이면
        printf(" %d",n->key);           //키 값 출력 후
        preOrder(n->lChild);
        preOrder(n->rChild);            //전위순회 실행
    }
}

int main(void) {                        //main 함수
    char c;
    int key;                            //변수 선언
    while(1){                           //반복문 선언
        scanf("%c",&c);                 //인자 받기
        if(c=='i'){                     //i 입력되면
            scanf("%d",&key);           //키 값 입력
            insertItem(key);            //트리에 삽입
        }
        else if(c=='d'){                //d 입력되면
            scanf("%d",&key);           //키 값 입력
            int k=removeElement(key);   //해당 노드 삭제 및 찾고
            if(k==-1){                  //노드 없다면
                printf("X\n");          //X 출력
            }
            else{                       //있다면
                printf("%d\n",k);       //해당 노드 키 출력
            }
        }
        else if(c=='s'){                //s 입력되면
            scanf("%d",&key);           //키 값 입력
            int k=findElement(key);     //해당 노드 찾고
            if(k==-1){                  //노드 없다면
                printf("X\n");          //X 출력
            }
            else{                       //있다면
                printf("%d\n",k);       //해당 노드 키 값 출력
            }
        }
        else if(c=='p'){                //p 입력되면
            preOrder(root);             //전위순회 출력
            printf("\n");
        }
        else if(c=='q'){                //q 입력되면
            break;                      //반복문 종료
        }
    }
    
    return 0;
}
