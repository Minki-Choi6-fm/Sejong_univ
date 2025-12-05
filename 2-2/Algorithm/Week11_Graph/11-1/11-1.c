#include <stdio.h>
#include <stdlib.h>

typedef struct AdjListNode {
    int dest;
    int weight;
    struct AdjListNode* next;
}AdjListNode;                                   //간선 노드를 표현한 구조체

typedef struct Graph {
    int V;
    AdjListNode** adjLists;
}Graph;                                         //정점 및 전체 그래프를 표현한 구조체

typedef struct Temp {
    int dest;
    int weight;
}Temp;                                          //오름차순 정렬을 위한 임시 구조체

AdjListNode* createNode(int dest, int weight) { //createNode 함수
    AdjListNode* newNode = (AdjListNode*)malloc(sizeof(AdjListNode));
    newNode->dest = dest;
    newNode->weight = weight;
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

void addEdge(Graph* graph, int src, int dest, int weight) { //addEdge 함수
    AdjListNode* newNode = createNode(dest, weight);
    newNode->next = graph->adjLists[src];
    graph->adjLists[src] = newNode;            //루프인 경우 여기까지만 진행

    if (src != dest) {
        newNode = createNode(src, weight);
        newNode->next = graph->adjLists[dest];
        graph->adjLists[dest] = newNode;        //루프가 아닐 경우 반대 방향에서도 해당 과정 진행
    }
}

void deleteEdgeOne(Graph* graph, int src, int dest) {   //deleteEdgeOne 함수
    AdjListNode* node = graph->adjLists[src];
    AdjListNode* prev = NULL;                  //단방향으로 지워주는 함수
    
    while (node != NULL) {
        if (node->dest == dest) {
            if (prev == NULL) {
                graph->adjLists[src] = node->next;
            } else {
                prev->next = node->next;
            }
            free(node);
            return;                             //해당 노드 찾은 후 삭제 및 연결리스트 다시 연결 후 종료
        }
        prev = node;
        node = node->next;
    }
}

void modifyEdge(Graph* graph, int src, int dest, int weight) {  //modifyEdge 함수
    if (src < 1 || src > 6 || dest < 1 || dest > 6) {   //정점이 없으면
        printf("-1\n");
        return;                                 //종료
    }
    
    if (weight == 0) {                          //삭제 조건이면
        deleteEdgeOne(graph, src, dest);        //삭제
        if (src != dest) {                      //루프가 아니면
            deleteEdgeOne(graph, dest, src);    //다른 방향인 것도 삭제
        }
        return;                                 //종료
    }
    
    AdjListNode* node = graph->adjLists[src];
    int found = 0;
    
    while (node != NULL) {
        if (node->dest == dest) {
            node->weight = weight;
            found = 1;
            break;
        }
        node = node->next;
    }                                           //해당되는 간선이 있는지 확인 및 가중치 바꿔주기
    
    if (!found) {                               //해당 되는 간선이 없으면
        addEdge(graph, src, dest, weight);      //새로 추가
        return;
    }
    
    if (src != dest) {                          //루프가 아닐 시
        node = graph->adjLists[dest];
        while (node != NULL) {
            if (node->dest == src) {
                node->weight = weight;
                break;
            }
            node = node->next;
        }                                       //다른 방향의 간선도 가중치 변경
    }
}

int compare(const void* a, const void* b) {     //compare 함수
    Temp* nodeA = (Temp*)a;
    Temp* nodeB = (Temp*)b;
    return (nodeA->dest - nodeB->dest);         //qsort의 오름차순 정렬을 위해 반환
}

void printNode(Graph* graph, int num) {         //printNode 함수
    if (num < 1 || num > 6) {                   //바르지 않은 정점이 들어오면
        printf("-1\n");
        return;                                 //-1 출력 후 종료
    }
    
    if (!graph->adjLists[num]) {                //정점에 간선이 연결되어 있지 않으면
        printf("-1\n");
        return;                                 //-1 출력 후 종료
    }
    
    int count = 0;
    AdjListNode* node = graph->adjLists[num];
    while (node != NULL) {
        count++;
        node = node->next;
    }                                           //해당 정점에 붙은 간선 개수 확인 후
    
    Temp* tempArray = (Temp*)malloc(count * sizeof(Temp));
    node = graph->adjLists[num];
    for (int i = 0; i < count; i++) {
        tempArray[i].dest = node->dest;
        tempArray[i].weight = node->weight;
        node = node->next;
    }                                           //임시 배열에 간선들 다 넣어 놓고
    
    qsort(tempArray, count, sizeof(Temp), compare); //qsort로 오름차순 정렬
    
    for (int i = 0; i < count; i++) {
        printf("%d %d ", tempArray[i].dest, tempArray[i].weight);
    }
    printf("\n");                               //오름차순 정렬한거 출력 후
    
    free(tempArray);                            //임시 배열 메모리 해제
}

int main(void) {                                //main 함수
    Graph* G = createGraph(7);
    char c;

    addEdge(G, 1, 2, 1);
    addEdge(G, 1, 3, 1);
    addEdge(G, 1, 4, 1);
    addEdge(G, 1, 6, 2);
    addEdge(G, 2, 3, 1);
    addEdge(G, 3, 5, 4);
    addEdge(G, 5, 5, 4);
    addEdge(G, 5, 6, 3);                        //문제에 나온 그래프 미리 그려주기
    
    while (1) {
        scanf(" %c", &c);
        if (c == 'a') {                         //a 입력되면
            int num;
            scanf("%d", &num);
            printNode(G, num);                  //printNode 함수 호출
        }
        if (c == 'm') {                         //m 입력되면
            int a, b, w;
            scanf("%d %d %d", &a, &b, &w);
            modifyEdge(G, a, b, w);             //modifyEdge 함수 호출
        }
        if (c == 'q') {                         //q 입력되면
            break;                              //프로그램 종료
        }
    }
    
    return 0;
}
