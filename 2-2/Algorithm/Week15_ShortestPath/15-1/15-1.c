#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#define MAX_n 100
#define MAX_m 1000
#define INF 2147483647

typedef struct AdjListNode {
    int dest;
    int weight;
    struct AdjListNode* next;
}AdjListNode;                                   //간선 노드를 표현한 구조체

typedef struct Graph {
    AdjListNode** adjLists;
}Graph;                                         //정점 및 전체 그래프를 표현한 구조체

typedef struct Elem{
    int dist;
    int v;
}Elem;                                          //우선순위 큐 요소를 담기 위한 구조체

typedef struct Queue{
    Elem heap[MAX_m*10];
    int size;
}Queue;                                         //우선순위 큐 구조체

Graph *G;

Graph *initializeGraph(void){                   //initializeGraph 함수
    Graph *g=(Graph*)malloc(sizeof(Graph));
    g->adjLists=(AdjListNode**)malloc((MAX_n+1)*sizeof(AdjListNode*));
    for(int i=0;i<=MAX_n;i++){
        g->adjLists[i]=NULL;
    }
    return g;                                   //그래프 만들어서 반환
}
AdjListNode* createNode(int dest, int weight) { //createNode 함수
    AdjListNode* newNode = (AdjListNode*)malloc(sizeof(AdjListNode));
    newNode->dest = dest;
    newNode->weight = weight;
    newNode->next = NULL;
    return newNode;                             //새 노드 만들고 반환
}
void addEdge(int src,int dest,int weight){      //addEdge 함수
    AdjListNode* newNode = createNode(dest, weight);
    newNode->next = G->adjLists[src];
    G->adjLists[src] = newNode;                 //루프인 경우 여기까지만 진행

    if (src != dest) {
        newNode = createNode(src, weight);
        newNode->next = G->adjLists[dest];
        G->adjLists[dest] = newNode;            //루프가 아닐 경우 반대 방향에서도 해당 과정 진행
    }
}

Queue* initializeQueue(void) {                  //initializeQueue 함수
    Queue* Q = (Queue*)malloc(sizeof(Queue));
    Q->size = 0;
    return Q;                                   //우선순위 큐 메모리 할당하고 반환
}

void push(Queue* Q, int v, int dist) {          //push 함수
    Q->size++;
    int i = Q->size;

    while ((i!=1)&&(dist<Q->heap[i/2].dist)){
        Q->heap[i] = Q->heap[i / 2];
        i /= 2;                                 //upHeap과정
    }
    Q->heap[i].v = v;
    Q->heap[i].dist = dist;                     //요소 넣어주기
}

Elem removeMin(Queue *Q) {                          //removeMin 함수
    Elem minNode = Q->heap[1];
    Elem lastNode = Q->heap[Q->size];
    Q->size--;

    int parent = 1;
    int child = 2;

    while (child <= Q->size) {
        if ((child < Q->size) && (Q->heap[child].dist > Q->heap[child + 1].dist)) {
            child++;
        }

        if (lastNode.dist <= Q->heap[child].dist) {
            break;
        }

        Q->heap[parent] = Q->heap[child];
        parent = child;
        child *= 2;
    }                                           //downHeap 과정
    Q->heap[parent] = lastNode;
    return minNode;                             //반환
}

void DijkstraShortestPath(int n,int s){         //DijkstraShortestPath 함수
    int d[n+1];
    int visit[n+1];
    for(int i=0;i<=n;i++){
        d[i]=INF;
        visit[i]=0;                             //각 정점 초기화
    }
    d[s]=0;
    Queue *Q = initializeQueue();
    push(Q, s, 0);                              //시작 정점 큐에 넣기
    while(Q->size>0){
        Elem elem=removeMin(Q);                  //가장 거리가 짧은 정점 꺼내기
        int u=elem.v;                           //그 정점의 번호 추출 후
        
        if(visit[u]==1){                        //혹시 이미 방문한거면
            continue;                           //패스
        }
        visit[u]=1;                             //그 정점 방문했다고 체크
        AdjListNode* node=G->adjLists[u];       //그 정점에 연결된 간선 탐색
        while(node!=NULL){
            int z=node->dest;                   //간선의 반대편과
            int weight=node->weight;            //간선의 가중치 뽑고
            if(d[u] != INF &&d[z]>d[u]+weight){
                d[z]=d[u]+weight;
                push(Q,z,d[z]);                 //반대편 정점 정보 갱신 후 큐에 넣어주기
            }
            node=node->next;
        }
    }
    for(int i=1;i<=n;i++){
        if(d[i]!=INF&&i!=s){
            printf("%d %d\n",i,d[i]);           //출력
        }
    }
}
    
int main(void) {                                //main 함수
    int n,m,s;
    G=initializeGraph();                        //그래프 메모리 할당
    
    scanf("%d %d %d",&n,&m,&s);
    for(int i=0;i<m;i++){
        int src,dest,weight;
        scanf("%d %d %d",&src,&dest,&weight);   //간선 정보 입력 후
        addEdge(src,dest,weight);               //간선 만들기
    }
    DijkstraShortestPath(n,s);                  //최단경로 찾기
    return 0;
}
