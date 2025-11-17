#include <stdlib.h>
#include <stdio.h>

typedef struct Graph {
    int V;
    int** adjMatrix;
    int* visited;
} Graph;                                                    //인접배열 구조체 선언

Graph* createGraph(int V){                                  //createGraph 함수
    Graph *G=(Graph *)malloc(sizeof(Graph));
    G->V=V;
    G->visited=(int *)calloc((V+1),sizeof(int));            //방문 여부 확인 배열 선언
    G->adjMatrix=(int **)calloc((V+1),sizeof(int*));
    for(int i=0;i<V+1;i++){
        G->adjMatrix[i]=(int *)calloc((V+1),sizeof(int));   //인접배열 구조 선언
    }
    return G;                                               //그래프 기본구조 선언 후 반환
}
void addEdge(Graph *graph, int src, int dest){              //addEdge 함수
    graph->adjMatrix[src][dest]=1;
    graph->adjMatrix[dest][src]=1;                          //간선 추가
}
void BFS(Graph *graph, int src){                            //BFS 함수
    int f=0,r=0;
    int queue[graph->V+1];                                  //큐 선언
    
    queue[r++]=src;                                         //큐에 시작하는 점 넣고
    graph->visited[src]=1;                                  //방문 여부 체크
    
    while(f<r){
        int a=queue[f++];                                   //큐에서 꺼내고
        printf("%d\n",a);                                   //해당 인자 출력
        for(int i=0;i<graph->V+1;i++){                      //인접배열 둘러보기
            if(graph->adjMatrix[a][i]==1&&graph->visited[i]==0){    //방문 안 했고 간선이 연결되어 있는 정점이 있으면
                queue[r++]=i;                               //큐에 넣고
                graph->visited[i]=1;                        //넣으면서 방문여부 넣기
            }
        }
    }
}
    
int main(void){                                             //main 함수
    int n,m,s;
    scanf("%d %d %d",&n,&m,&s);                             //입력
    Graph *G=createGraph(n);                                //그래프 기본구조 설계
    
    for(int i=0;i<m;i++){
        int a,b;
        scanf("%d %d",&a,&b);                               //입력
        addEdge(G,a,b);
    }
    
    BFS(G,s);                                               //BFS 실행
    
    return 0;
}
