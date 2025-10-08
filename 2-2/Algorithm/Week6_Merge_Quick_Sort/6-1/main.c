#include <stdlib.h>
#include <stdio.h>                              //헤더 선언

typedef struct Node {
    int elem;
    struct Node* next;
} Node;                                         //리스트 안 노드 구조체 선언

typedef struct List {
    Node* Head;
    int length;
} List;                                         //리스트 구조체 선언

typedef struct divide {
    List* a;
    List* b;
} divide;                                       //두 리스트 반환을 위한 divide 구조체 선언

List* initializeList(int n) {                   //initializeList 함수
    List* list = (List*)malloc(sizeof(List));
    list->Head = (Node*)malloc(sizeof(Node));
    list->length = n;
    list->Head->next = NULL;
    return list;                                //새 리스트 선언 및 반환
}

void add(List *list, int input) {               //add 함수
    Node *node = (Node*)malloc(sizeof(Node));
    node->elem = input;
    node->next = NULL;
    Node *prev = list->Head;
    while (prev->next != NULL) {
        prev = prev->next;
    }
    prev->next = node;                          //리스트 맨 뒤에 새 노드 생성 및 붙이기
}

divide* partition(List* L) {                    //partition 함수
    divide* div = (divide*)malloc(sizeof(divide));
    int mid = L->length / 2;

    List* L1 = initializeList(mid);
    List* L2 = initializeList(L->length - mid); //두 분할 리스트 선언

    free(L1->Head);                             //메모리 누수 막기 위해 free 선언
    L1->Head = L->Head;                         //왼쪽인 L1의 헤더는 곧 기존 L의 헤더와 같기에 선언

    Node* cut_point = L1->Head;
    for (int i = 0; i < mid; i++) {
        cut_point = cut_point->next;            //가운데를 찾기 위해 노드 보내기
    }

    L2->Head->next = cut_point->next;           //L2는 가운데부터 끝까지이므로 이렇게 선언
    cut_point->next = NULL;                     //L1 끝에 L2와 연결되어 있는거 끊기

    free(L);                                    //필요 없어진 L 메모리 해제

    div->a = L1;
    div->b = L2;                                //두 부리스트들 div에 담고
    return div;                                 //반환
}

List* merge(List* L1, List* L2) {               //merge 함수
    List* L = initializeList(L1->length + L2->length);
    Node* current = L->Head;

    Node* p1 = L1->Head->next;
    Node* p2 = L2->Head->next;                  //진짜 노드부터 시작하게 설정

    while (p1 != NULL && p2 != NULL) {          //둘중 하나 빌때까지 반복
        if (p1->elem <= p2->elem) {             //L1의 요소가 작거나 같으면
            current->next = p1;
            p1 = p1->next;                      //L1의 요소 L에 붙이고 L1은 다음걸로 넘기기
        } else {                                //L2가 작으면
            current->next = p2;
            p2 = p2->next;                      //L2의 요소 L에 붙이고 L2는 다음걸로 넘기기
        }
        current = current->next;                //L의 노드도 다음걸로 넘겨주기
    }

    if (p1 != NULL) {                           //L1이 남았으면
        current->next = p1;                     //남은거 L에 붙여주기
    } else {                                    //L2가 남았으면
        current->next = p2;                     //남은거 L에 붙여주기
    }

    free(L1->Head);
    free(L1);
    free(L2->Head);
    free(L2);                                   //메모리 해제

    return L;                                   //합친 리스트 반환
}

List* mergeSort(List* L) {                      //mergeSort 함수
    if (L->length <= 1) {                       //1개 이하의 요소가 있으면
        return L;                               //해당 리스트 반환
    }

    divide* div = partition(L);                 //L 반으로 쪼개기

    div->a = mergeSort(div->a);
    div->b = mergeSort(div->b);                 //쪼갠 부리스트들 재귀호출

    List* merged_list = merge(div->a, div->b);  //부리스트들 합치기
    
    free(div);                                  //메모리 해제
    
    return merged_list;                         //다 된 리스트 반환
}

int main(void) {                                //main 함수
    int n, m;
    scanf("%d", &n);                            //리스트 길이 입력
    List* list = initializeList(n);             //리스트 선언

    for (int i = 0; i < n; i++) {
        scanf("%d", &m);
        add(list, m);                           //리스트 요소 입력
    }

    list = mergeSort(list);                     //합병정렬 실행

    Node *node = list->Head->next;
    while (node != NULL) {
        printf(" %d", node->elem);              //리스트 출력
        node = node->next;
    }
    return 0;                                   //0 반환
}
