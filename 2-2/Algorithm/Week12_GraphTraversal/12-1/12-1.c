#include <stdio.h>
#include <stdlib.h>

typedef struct AdjListNode {
    int dest;
    struct AdjListNode* next;
}AdjListNode;                                   //간선 노드를 표현한 구조체

typedef struct Graph {
    int V;
    AdjListNode** adjLists;
}Graph;                                         //정점 및 전체 그래프를 표현한 구조체

AdjListNode* createNode(int dest) { //createNode 함수
    AdjListNode* newNode = (AdjListNode*)malloc(sizeof(AdjListNode));
    newNode->dest = dest;
    newNode->next = NULL;
    return newNode;                             //새 노드 만들고 반환
}

Graph* createGraph(int V) {                     //createGraph 함수
    Graph* graph = (Graph*)malloc(sizeof(Graph));
    graph->V = V;
    graph->adjLists = (AdjListNode**)malloc(V * sizeof(AdjListNode*));  //그래프 초기 설정 후
    for (int i = 0; i < V; ++i) {
        graph->adjLists[i] = NULL;              //각 정점 연결상태 초기화 후
    }
    return graph;                               //그래프 반환
}

void addEdge(Graph* graph, int src, int dest) { //addEdge 함수
    AdjListNode* newNode = createNode(dest);
    newNode->next = graph->adjLists[src];
    graph->adjLists[src] = newNode;            //루프인 경우 여기까지만 진행

    if (src != dest) {
        newNode = createNode(src);
        newNode->next = graph->adjLists[dest];
        graph->adjLists[dest] = newNode;        //루프가 아닐 경우 반대 방향에서도 해당 과정 진행
    }
}

int main(void) {                                //main 함수
    int n,m,s;
    scanf("%d %d %d",&n,&m,&s);
    Graph* G = createGraph(n);
    
    for(int i=0;i<m;i++){
        int a,b;
        scanf("%d %d",&a,&b);
        addEdge(G, a, b);
    }
    
    return 0;
}
