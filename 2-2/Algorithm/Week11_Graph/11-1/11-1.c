#include <stdio.h>
#include <stdlib.h>

typedef struct AdjListNode {
    int dest;
    int weight;
    struct AdjListNode* next;
}AdjListNode;

typedef struct Graph {
    int V;
    struct AdjListNode** adjLists;
}Graph;

typedef struct Temp {
    int dest;
    int weight;
}Temp;

AdjListNode* createNode(int dest, int weight) {
    AdjListNode* newNode = (AdjListNode*)malloc(sizeof(AdjListNode));
    newNode->dest = dest;
    newNode->weight = weight;
    newNode->next = NULL;
    return newNode;
}

Graph* createGraph(int V) {
    Graph* graph = (Graph*)malloc(sizeof(Graph));
    graph->V = V;

    graph->adjLists = (AdjListNode**)malloc(V * sizeof(AdjListNode*));

    for (int i = 0; i < V; ++i) {
        graph->adjLists[i] = NULL;
    }
    return graph;
}

void addEdge(Graph* graph, int src, int dest, int weight) {
    AdjListNode* newNode = createNode(dest, weight);
    newNode->next = graph->adjLists[src];
    graph->adjLists[src] = newNode;

    if (src != dest) {
        newNode = createNode(src, weight);
        newNode->next = graph->adjLists[dest];
        graph->adjLists[dest] = newNode;
    }
}
int compare(const void* a, const void* b) {
    Temp* nodeA = (Temp*)a;
    Temp* nodeB = (Temp*)b;
    return (nodeA->dest - nodeB->dest);
}
void printNode(Graph* graph,int num){
    if(!graph->adjLists[num]){
        printf("-1\n");
        return;
    }
    int count=0;
    AdjListNode *node=graph->adjLists[num];
    while(node!=NULL){
        count++;
        node=node->next;
    }
    Temp* tempArray = (Temp*)malloc(count * sizeof(Temp));
    node = graph->adjLists[num];
    for (int i = 0; i < count; i++) {
        tempArray[i].dest = node->dest;
        tempArray[i].weight = node->weight;
        node = node->next;
    }
    qsort(tempArray, count, sizeof(tempArray), compare);
}
void fixEdge(Graph* graph,int src, int dest, int weight){
    
}
int main(void){
    Graph* G=createGraph(7);
    char c;

    addEdge(G, 1, 2, 1);
    addEdge(G, 1, 3, 1);
    addEdge(G, 1, 4, 1);
    addEdge(G, 1, 6, 2);
    addEdge(G, 2, 3, 1);
    addEdge(G, 3, 5, 4);
    addEdge(G, 5, 5, 4);
    addEdge(G, 5, 6, 3);
    
    while(1){
        scanf("%c",&c);
        if(c=='a'){
            int num;
            scanf("%d",&num);
            printNode(G, num);
        }
        if(c=='m'){
            int a,b,w;
            scanf("%d %d %d",&a,&b,&w);
            fixEdge(G, a, b, w);
        }
        if(c=='q'){
            break;
        }
    }
    return 0;
}
