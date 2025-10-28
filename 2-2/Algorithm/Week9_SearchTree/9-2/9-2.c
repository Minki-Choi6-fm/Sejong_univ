#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

typedef struct Node{
    struct Node *parent;
    int key;
    int height;
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

int getHeight(Node *w) {                    //getHeight 함수
    if (w == NULL || isExternal(w)) {       //해당하지 않는 노드면
        return 0;                           //0 반환
    }
    return w->height;                       //맞으면 높이 반환
}

bool updateHeight(Node *w){                 //updateHeight 함수
    if (w == NULL || isExternal(w)) {       //해당하지 않는 노드면
        return false;                       //false 반환
    }
    
    int lH = getHeight(w->lChild);
    int rH = getHeight(w->rChild);
    int newHeight = (lH > rH ? lH : rH) + 1; //새로운 높이

    if(w->height != newHeight){
        w->height = newHeight;          //새로운 높이가 기존 높이와 다르면 바꾸기
        return true;                    //true 반환
    }
    return false;                       //교환이 없으면 false 반환
}

bool isBalanced(Node *w){               //isBalanced 함수
    int l=w->lChild->height;
    int r=w->rChild->height;
    if(abs(l-r)>1){                     //둘이 높이 차가 1 초과로 나면
        return false;                   //false 반환
    }
    else{                               //별로 차이 안 나면
        return true;                    //true 반환
    }
}

Node* restructure(Node *x,Node *y,Node *z){         //restructure 함수
    Node *a, *b, *c;                                //개조 되는 노드들
    Node *T0, *T1, *T2, *T3;                        //개조 되는 노드에 딸린 외부 노드들
    Node *z_parent = z->parent;                     //z의 부모 저장

    if (z->key < y->key && y->key < x->key) {                           // R-R Case
        a = z; b = y; c = x;
        T0 = a->lChild; T1 = b->lChild; T2 = c->lChild; T3 = c->rChild;
    } else if (x->key < y->key && y->key < z->key) {                    // L-L Case
        a = x; b = y; c = z;
        T0 = a->lChild; T1 = a->rChild; T2 = b->rChild; T3 = c->rChild;
    } else if (z->key < x->key && x->key < y->key) {                    // R-L Case
        a = z; b = x; c = y;
        T0 = a->lChild; T1 = b->lChild; T2 = b->rChild; T3 = c->rChild;
    } else {                                                            // L-R Case
        a = y; b = x; c = z;
        T0 = a->lChild; T1 = b->lChild; T2 = b->rChild; T3 = c->rChild;
    }

    if (z_parent!=NULL){                            //z를 루트로 하는 부트리를 b를 루트로 하는 부트리로 대체
        if (z_parent->lChild==z){
            z_parent->lChild=b;
        }
        else{
            z_parent->rChild=b;
        }
    }
    b->parent=z->parent;

    a->lChild=T0;
    a->rChild=T1;
    if(T0!=NULL){
        T0->parent=a;
    }
    if(T1!=NULL){
        T1->parent=a;
    }                                               //T0와 T1을 각각 a의 왼쪽 및 오른쪽 부트리로 만듦
        
    c->lChild=T2;
    c->rChild=T3;
    if(T2!=NULL){
        T2->parent=c;
    }
    if(T3!=NULL){
        T3->parent=c;
    }                                               //T2와 T3를 각각 c의 왼쪽 및 오른쪽 부트리로 만듦
        
    b->lChild=a;
    b->rChild=c;
    a->parent=b;
    c->parent=b;                                    //a와 c를 각각 b의 왼쪽 및 오른쪽 자식으로 만듦

    return b;                                       //b 반환
}

void searchAndFixAfterInsertion(Node *w){           //searchAndFixAfterInsertion 함수
    Node *curr = w;
    while(curr != NULL){
        updateHeight(curr);                         //루트로 올라가면서 높이 갱신
        if(!isBalanced(curr)){                      //불균형한 노드가 발견되면
            Node *z = curr;
            Node *y = (getHeight(z->lChild) > getHeight(z->rChild)) ? z->lChild : z->rChild;
            Node *x = (getHeight(y->lChild) > getHeight(y->rChild)) ? y->lChild : y->rChild;    //위치가 바뀌는 세 노드 찾은 뒤
            Node *b = restructure(x, y, z);         //개조 실행
            
            updateHeight(b->lChild);
            updateHeight(b->rChild);
            updateHeight(b);                        //개조 후 바뀐 노드들의 높이를 갱신
            
            curr = b;                           
        }
        curr = curr->parent;
    }
}

void insertItem(int key){                           //insertItem 함수
    if(root==NULL){                                 //루트가 비어 있으면
        root = (Node*)malloc(sizeof(Node));
        root->parent = NULL;
        root->key = key;
        root->height=1;
        
        root->lChild = (Node*)malloc(sizeof(Node));
        root->lChild->parent = root;
        root->lChild->height=0;
        root->lChild->lChild = NULL;
        root->lChild->rChild = NULL;
        
        root->rChild = (Node*)malloc(sizeof(Node));
        root->rChild->parent = root;
        root->rChild->height=0;
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
        w->height = 1;

        w->lChild = (Node*)malloc(sizeof(Node));
        w->lChild->parent = w;
        w->lChild->height = 0;
        w->lChild->lChild = NULL;
        w->lChild->rChild = NULL;

        w->rChild = (Node*)malloc(sizeof(Node));
        w->rChild->parent = w;
        w->rChild->height = 0;
        w->rChild->lChild = NULL;
        w->rChild->rChild = NULL;
        
        searchAndFixAfterInsertion(w);
        
        return;                                     //삽입 후 종료
    }
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
