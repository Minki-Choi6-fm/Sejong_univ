#include <stdlib.h>
#include <stdio.h>

#define MAX_V 100
#define MAX_E 1000

typedef struct Edge{
    int u;
    int v;
    int weight;
}Edge;                                                  //구조체 선언

Edge edges[MAX_E];
int parent[MAX_V + 1];
int rank[MAX_V + 1];
int n,m;                                                //변수 및 간선리스트 선언

void make_set(int n) {                                  //make_set 함수
    for (int i = 1; i <= n; i++) {
        parent[i] = i;
        rank[i] = 0;                                    //초기화
    }
}

int find_set(int u) {                                   //find_set 함수
    if (parent[u] != u) {
        parent[u] = find_set(parent[u]);                //최종 우두머리 찾기
    }
    return parent[u];
}
    
void union_set(int u, int v) {                          //union_set 함수
    int rootU = find_set(u);
    int rootV = find_set(v);

    if (rootU != rootV) {                               //rank가 큰 쪽으로 작은 덩아리가 붙는 구조
        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        }
        else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        }
        else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }
}

void KruskalMST(void) {                                         //KruskalMst 함수
    int edgeCount = 0;
    int totalWeight = 0;                                        //카운트 변수 선언

    make_set(n);                                                //초기화
    for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Edge temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;                        //가중치 순으로 정렬
                }
            }
        }

    for (int i = 0; i < m; i++) {
        int u = edges[i].u;
        int v = edges[i].v;
        int w = edges[i].weight;                                //간선 정보 꺼내기

        if (find_set(u) != find_set(v)) {                       //다른 팀이면
            printf("%d\n", w);
            totalWeight += w;
            union_set(u, v);                                    //두 팀 합쳐주기
            edgeCount++;
            if (edgeCount == n - 1){                            //전부 다 돌았으면
                break;                                          //종료
            }
        }
    }
    printf("%d\n", totalWeight);                                //총 가중치 출력
}

int main(void) {                                                //main 함수
    scanf("%d %d", &n, &m);

    for (int i = 0; i < m; i++) {
        scanf("%d %d %d", &edges[i].u, &edges[i].v, &edges[i].weight);
    }

    KruskalMST();

    return 0;
}
