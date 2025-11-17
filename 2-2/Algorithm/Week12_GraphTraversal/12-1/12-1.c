#include <stdio.h>
#include <stdlib.h>

typedef struct AdjListNode {
    int dest;
    struct AdjListNode* next;
}AdjListNode;                                   //간선 노드를 표현한 구조체

typedef struct Graph {
    int V;
    AdjListNode** adjLists;
    int* visit;
}Graph;                                         //정점 및 전체 그래프를 표현한 구조체

AdjListNode* createNode(int dest) {             //createNode 함수
    AdjListNode* newNode = (AdjListNode*)malloc(sizeof(AdjListNode));
    newNode->dest = dest;
    newNode->next = NULL;
    return newNode;                             //새 노드 만들고 반환
}

Graph* createGraph(int V) {                     //createGraph 함수
    Graph* graph = (Graph*)malloc(sizeof(Graph));
    graph->V = V;
    graph->adjLists = (AdjListNode**)malloc((V+1) * sizeof(AdjListNode*));  //그래프 초기 설정 후
    graph->visit=(int*)malloc((V+1)*sizeof(int));
    for (int i = 0; i < V; ++i) {
        graph->adjLists[i] = NULL;              //각 정점 연결상태 초기화 후
    }
    return graph;                               //그래프 반환
}

void addEdge(Graph* graph, int src, int dest) { //addEdge 함수
    AdjListNode* newNode = createNode(dest);
    AdjListNode* node = graph->adjLists[src];
    AdjListNode* prev = NULL;

    while (node != NULL && node->dest < dest) {
        prev = node;
        node = node->next;
    }

    newNode->next = node;
    if (prev == NULL) {
        graph->adjLists[src] = newNode;
    }
    else {
        prev->next = newNode;                   //애초에 간선을 오름차순 순으로 넣기
    }                                           //단방향인 경우 여기까지

    if (src != dest) {
        AdjListNode* newNodeRev = createNode(src);
        node = graph->adjLists[dest];
        prev = NULL;

        while (node != NULL && node->dest < src) {
            prev = node;
            node = node->next;
        }

        newNodeRev->next = node;
        if (prev == NULL) {
            graph->adjLists[dest] = newNodeRev;
        }
        else {
            prev->next = newNodeRev;
        }                                       //양방향인 경우 여기까지
    }
}

void DFS(Graph *graph, int src){                //DFS 함수
    graph->visit[src]=1;
    printf("%d\n",src);                         //방문 처리 후 출력
    AdjListNode* node=graph->adjLists[src];
    while(node!=NULL){
        if(graph->visit[node->dest]==0){
            DFS(graph,node->dest);              //DFS 탐색
        }
        node=node->next;
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
    
    DFS(G,s);
    
    return 0;
}
