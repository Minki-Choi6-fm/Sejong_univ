#include <stdlib.h>
#include <stdio.h>

typedef struct Node{
    int elem;
    struct Node* next;
}Node;

typedef struct Edge{
    int origin;
    int dest;
}Edge;

typedef struct Vertex{
    char name;
    int inDegree;
    Node *outEdges;
    Node *inEdges;
}Vertex;

typedef struct DiGraph{
    Vertex *vertices[100];
    Edge *edges[1000];
}DiGraph;

DiGraph *G;
int n,m;
int *Q,*topOrder;

DiGraph *initializeGraph(void){
    DiGraph *g=(DiGraph*)malloc(sizeof(DiGraph));
    for(int i=0;i<1000;i++){
        g->edges[i]=NULL;
        if(i<100){
            g->vertices[i]=NULL;
        }
    }
    return g;
}

void insertVertex(char vName,int i){
    G->vertices[i]->name=vName;
    G->vertices[i]->outEdges=NULL;
    G->vertices[i]->inEdges=NULL;
    G->vertices[i]->inDegree=0;
    return;
}
int index_return(char vName){
    for(int i=0;i<n;i++){
        if(G->vertices[i]->name==vName){
            return i;
        }
    }
    return -1;
}

void addFirst(Node *node,int i){
    Node *N=(Node *)malloc(sizeof(Node));
    N->elem=i;
    N->next=node->next;
}

void insertDirectedEdge(char uName, char wName, int i){
    int u=index_return(uName);
    int w=index_return(wName);
    
    G->edges[i]->origin=u;
    G->edges[i]->dest=w;
    
    addFirst(G->vertices[i]->outEdges,i);
    addFirst(G->vertices[i]->inEdges,i);
    
    G->vertices[i]->inDegree++;
    
    return;
}

void buildGraph(void){
    G=initializeGraph();
    
    scanf("%d",&n);
    
    for(int i=0;i<n;i++){
        char vName;
        scanf("%c",&vName);
        insertVertex(vName, i);
    }
    
    scanf("%d",&m);
    
    for(int i=0;i<m;i++){
        char uName,wName;
        scanf("%c %c",&uName,&wName);
        insertDirectedEdge(uName, wName, i);
    }
    
    return;
}

int main(void) {
    buildGraph();
    topologicalSort();
    if(topOrder[0]=0){
        write(0);
    }
    else{
        for(int i=1;i<n;i++){
            write(G.vertices[topOrder[i]].name);
        }
    }
    return 0;
}

