#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#define MAX_n 100
#define MAX_m 1000
#define INF 10000000

typedef struct Edge{
    int src;
    int dest;
    int weight;
}Edge;
    
Edge edges[MAX_m];                              //간선리스트
int size=0;                                     //간선 개수

void addEdge(int src,int dest,int weight){      //addEdge 함수
    edges[size].src=src;
    edges[size].dest=dest;
    edges[size].weight=weight;
    size++;                                     //배열에 간선 추가
}

void BellmanFordShortestPath(int n,int s){      //BellmanFordShortestPath 함수
    int d[n+1];
    for(int i=1;i<=n;i++){
        d[i]=INF;                               //큰 수로 초기화
    }
    d[s]=0;                                     //시점은 0으로 초기화
    for(int i=1;i<n;i++){
        for(int j=0;j<size;j++){
            int u=edges[j].src;
            int z=edges[j].dest;
            if (d[u]!=INF){
                if (d[z]>d[u]+edges[j].weight){
                    d[z]=d[u]+edges[j].weight;
                }                               //비교하면서 n-1번 무게 최신화
            }
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
    scanf("%d %d %d",&n,&m,&s);
    for(int i=0;i<m;i++){
        int src,dest,weight;
        scanf("%d %d %d",&src,&dest,&weight);   //간선 정보 입력 후
        addEdge(src,dest,weight);               //간선 만들기
    }
    BellmanFordShortestPath(n,s);               //최단경로 찾기
    return 0;
}
