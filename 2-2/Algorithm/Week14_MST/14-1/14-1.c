#include <stdlib.h>
#include <stdio.h>

#define MAX_V 100
#define MAX_E 1000
#define INF 2147483647

typedef struct Edge{
    int weight;
    int dest;
    struct Edge* next;
} Edge;

typedef struct Graph{
    int vertice;
    int edge;
    Edge** adjList;
} Graph;                                    //그래프 구현

Graph *G;
int n, m;
int *Q;
int *d, *p;
int MAX = 0;                                //전역 변수 및 큐 및 그래프 선언

void initializeGraph(void){                 //initializeGraph 함수
    G = (Graph*)malloc(sizeof(Graph));
    G->adjList = (Edge**)malloc(sizeof(Edge) * (n + 1));
    for(int i = 1; i <= n; i++){
        G->adjList[i] = NULL;
    }                                       //그래프 내부 요소들 메모리 할당
}

Edge* createEdge(int start, int dest, int kg){  //createEdge 함수
    Edge* edge = (Edge*)malloc(sizeof(Edge));
    edge->weight = kg;
    edge->dest = dest;
    edge->next = NULL;
    return edge;                            //간선 메모리 할당 후 반환
}

void addEdge(void){                         //addEdge 함수
    int src, dest, kg;
    scanf("%d %d %d", &src, &dest, &kg);

    Edge* newNode = createEdge(src, dest, kg);
    Edge* node = G->adjList[src];
    Edge* prev = NULL;                      //메모리 할당
        
    while (node != NULL && node->dest < dest) {
        prev = node;
        node = node->next;
    }                                       //오름차순으로 넣게 위치 찾기

    newNode->next = node;
    if (prev == NULL) {
        G->adjList[src] = newNode;          //한번도 뒤로 안 넘어갔으면 그냥 꽂기
    }
    else {
        prev->next = newNode;               //아니면 그 찾은 자리에 꽂기
    }

    if (src != dest) {                      //무방향 그래프 특성상 반대로도 오는 경우가 있다면
        Edge* newNodeRev = createEdge(dest, src, kg);
        node = G->adjList[dest];
        prev = NULL;

        while (node != NULL && node->dest < src) {
            prev = node;
            node = node->next;
        }

        newNodeRev->next = node;
        if (prev == NULL) {
            G->adjList[dest] = newNodeRev;
        }
        else {
            prev->next = newNodeRev;
        }                                   //동일 과정 반복
    }
}

void build(void){                       //buildHeap 함수
    for(int i = 1; i <= n; i++){
        Q[i] = 1;                           //큐 다 1로 초기화
    }
}

int remove_arr(void){                       //removeHeap 함수
    int minNode = 0;
    int minVal = INF;
    for(int i = 1; i <= n; i++){
        if(Q[i] == 1 && d[i] < minVal){
            minVal = d[i];
            minNode = i;
        }
    }
    if(minNode != 0) {
        Q[minNode] = 0;
    }
    return minNode;
}

void PrimJarnikMST(int n){                  //PrmJarnikMST 함수
    Q = (int*)malloc(sizeof(int) * (n + 1));
    d = (int*)malloc(sizeof(int) * (n + 1));
    p = (int*)malloc(sizeof(int) * (n + 1));
    int sum = 0, size = n;

    for(int i = 1; i <= n; i++){
        d[i] = INF;
        p[i] = -1;                          //각 비용 및 부모 초기화
    }
    d[1] = 0;                               //첫번째 점 비용 0으로 설정
    
    build();
    
    while(size > 0){                        //다 돌 때까지 반복
        int u = remove_arr();               //배열에서 제거
        if(u == 0) {
            break;                          //오류 처리
        }
        
        printf("%d\n", u);                  //출력 하고
        sum += d[u];                        //비용 추가 뒤
        size--;                             //남은 정점 개수 줄이고

        Edge* cur = G->adjList[u];
        while(cur != NULL){
            int v = cur->dest;
            int weight = cur->weight;
            
            if(Q[v] == 1 && weight < d[v]){
                d[v] = weight;
                p[v] = u;
            }
            cur = cur->next;                //해당 정점에 연결된 간선 가중치 싹다 탐색 및 비교하여 배열에 넣기
        }
    }
    printf("%d\n", sum);                    //총 비용 출력
}
    
int main(void) {                            //main함수
    scanf("%d %d", &n, &m);
    initializeGraph();
    
    for(int i = 0; i < m; i++){
        addEdge();
    }
    PrimJarnikMST(n);
    return 0;
}
