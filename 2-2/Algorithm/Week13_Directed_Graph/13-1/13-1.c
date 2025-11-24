#include <stdlib.h>
#include <stdbool.h>
#include <stdio.h>

typedef struct Node{                                    //out,inEdge를 여러개 연속으로 담기 위한 구조체
    int elem;
    struct Node* next;
}Node;                                                  //node 구조체 선언

typedef struct Edge{                                    //A->B 간선
    int origin;                                         //A
    int dest;                                           //B
}Edge;                                                  //간선 구조체 선언

typedef struct Vertex{                                  //정점의 역할을 하는 구조체
    char name;                                          //정점 이름
    int inDegree;                                       //해당 정점에 도착하는 간선 개수
    Node *outEdges;                                     //해당 정점에서 출발하는 간선들
    Node *inEdges;                                      //해당 정점에 도착하는 간선들
}Vertex;                                                //정점 구조체 선언
    
typedef struct DiGraph{                                 //그래프 구조체
    Vertex *vertices[100];                              //정점
    Edge *edges[1000];                                  //간선
}DiGraph;                                               //그래프 구조체 선언

DiGraph *G;                                             //그래프 전역으로 선언
int n,m,front=0,rear=0;;                                //변수들 선언
int *Q,*topOrder;                                       //큐 및 위상정렬 담아둘 배열 선언

DiGraph *initializeGraph(void){                         //initializeGraph 함수
    DiGraph *g=(DiGraph*)calloc(1,sizeof(DiGraph));     //그래프 메모리 할당
    return g;                                           //그래프 반환
}

void insertVertex(char vName,int i){                    //insertVertex 함수
    G->vertices[i] = (Vertex*)malloc(sizeof(Vertex));   //메모리 할당
    G->vertices[i]->name=vName;                         //정점에 이름 넣기
    G->vertices[i]->outEdges = (Node*)malloc(sizeof(Node)); //메모리 할당
    G->vertices[i]->outEdges->next = NULL;

    G->vertices[i]->inEdges = (Node*)malloc(sizeof(Node));  //메모리 할당
    G->vertices[i]->inEdges->next = NULL;
    G->vertices[i]->inDegree=0;                         //카운트(?) 0으로 초기화
    return;
}

int index_return(char vName){                           //index_return 함수
    for(int i=0;i<n;i++){
        if(G->vertices[i]->name==vName){
            return i;                                   //정점 이름 가지고 해당 정점이 있는 배열의 인덱스 반환
        }
    }
    return -1;                                          //없으면 -1 반환
}

void addFirst(Node *node,int i){                        //addFirst 함수
    Node *N=(Node *)malloc(sizeof(Node));
    N->elem=i;
    N->next=node->next;
    node->next=N;                                       //문제 요구 사항대로 앞에 넣어주기
    return;
}

void enqueue(int *queue,int i){                         //enqueue 함수
    queue[rear++]=i;
}

int dequeue(int *queue){                                //dequeue 함수
    return queue[front++];
}

bool isEmpty(int *queue){                               //isEmpty 함수
    if(front>=rear){
        return true;
    }
    else{
        return false;
    }
}
    
void topologicalSort(void){                             //topologicalSort 함수
    front=0;
    rear=0;                                             //일단 큐 front,rear를 0으로 초기화 함으로써 사실상 큐 초기화
    int in[n];                                          //각 정점의 inDegree를 한 배열에 저장하기 위한 in 배열 선언
    for(int i=0;i<n;i++){
        in[i]=G->vertices[i]->inDegree;                 //각 정점의 inDegree를 담기
        if(in[i]==0){                                   //만약 inDegree가 0이면
            enqueue(Q,i);                               //바로 큐에 넣기
        }
    }
    int t=1;                                            //위상정렬 배열 담기 위한 인자
    while(!isEmpty(Q)){
        int u=dequeue(Q);
        topOrder[t]=u;                                  //큐에서 꺼내 위상정렬에 넣어주고
        t++;
        Node *node=G->vertices[u]->outEdges->next;      //그냥 outEdges는 헤더노드이므로 next로 넘겨서부터 체크, 나가는 간선 뽑기
        while(node!=NULL){
            int w=G->edges[node->elem]->dest;           //뽑은 간선의 맞은 편 정점의 배열 저장 인자
            in[w]--;                                    //inDegree 개수 하나 줄이고(실제 Vertex의 inDegree값 건드는 것이 아닌 아까 선언한 in배열 값을 건들기(편의를 위해))
            if(in[w]==0){                               //inDegree값 0이면
                enqueue(Q, w);                          //큐에 넣기
            }
            node=node->next;                            //다음 outEdge로 넘어가기
        }
        
    }
    if(t<=n){                                           //만약 사이클이 있다면(A->B->C->A인 사이클이 있다고 가정하면 애초에 처음 for문에서 enqueue에 하나도 안 들어감, 그래서 t값이 n보다 작은거)
        topOrder[0]=0;                                  //topOrder[0]을 0으로 설정해 위상정렬 불가 표시
    }
    else{                                               //사이클 없으면
        topOrder[0]=1;                                  //위상정렬 가능 표시
    }
}

void insertDirectedEdge(char uName, char wName, int i){ //insertDirectedEdge 함수
    int u=index_return(uName);
    int w=index_return(wName);                          //이름으로 인덱스 찾기
    
    G->edges[i]=(Edge*)malloc(sizeof(Edge));
    G->edges[i]->origin=u;
    G->edges[i]->dest=w;                                //간선 만들고
    addFirst(G->vertices[u]->outEdges,i);
    addFirst(G->vertices[w]->inEdges,i);                //해당하는 두 정점에 표시
    G->vertices[w]->inDegree++;                         //inDegree 값 늘리기
    
    return;
}

void buildGraph(void){                                  //buildGraph 함수
    G=initializeGraph();                                //그래프 초기설정
    
    scanf("%d",&n);
    Q=(int *)calloc(n,sizeof(int));
    topOrder=(int *)calloc(n+1,sizeof(int));            //배열 동적할당
    
    for(int i=0;i<n;i++){
        char vName;
        scanf(" %c",&vName);
        insertVertex(vName, i);                         //들어 갈 정점 뭐 있는지 받은 후 정점 구성
    }
    
    scanf("%d",&m);
    
    for(int i=0;i<m;i++){
        char uName,wName;
        scanf(" %c %c",&uName,&wName);
        insertDirectedEdge(uName, wName, i);            //들어갈 간선 입력 후 구성
    }
    
    return;
}

int main(void) {                                        //main 함수
    buildGraph();                                       //그래프 만들고
    topologicalSort();                                  //위상정렬 한 뒤
    if(topOrder[0]==0){                                 //만약 위상정렬 불가하면
        printf("0");                                    //0 출력
    }
    else{                                               //가능하다면
        for(int i=1;i<=n;i++){
            printf("%c ",G->vertices[topOrder[i]]->name);   //위상정렬 값 출력
        }
    }
    free(Q);
    free(topOrder);
    return 0;
}

