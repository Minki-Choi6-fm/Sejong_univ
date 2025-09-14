#include <stdio.h>
#include <stdlib.h>
#include <string.h>                 //헤더 선언

typedef struct Node {
    char elem;
    struct Node* prev;
    struct Node* next;
}Node;

typedef struct List {
    Node* head;
    Node* tail;
}List;

List* initializeList(void) {        //initializeList 함수(구조체 초기화)
    List* a = (List*)malloc(sizeof(List));      //리스트 선언
    a->head = (Node*)malloc(sizeof(Node));      //노드 선언
    a->tail = (Node*)malloc(sizeof(Node));
    a->head->next = a->tail;
    a->tail->prev = a->head;
    return a;                                   //초기화 후 반환
}
void add(List* a, int r, char e) {
    Node* node = (Node*)malloc(sizeof(Node));
    Node* n = a->head;
    node->elem = e;
    for (int i = 0;i < r;i++) {
        n = n->next;
    }
    node->next = n;
    node->prev = n->prev;
    n->prev->next = node;
    n->prev = node;
}
void delete(List* a, int r) {
    Node* n = a->head;
    for (int i = 0;i < r;i++) {
        n = n->next;
    }
    n->prev->next = n->next;
    n->next->prev = n->prev;
    free(n);
}
char get(List* a, int r) {
    Node* n = a->head;
    for (int i = 0;i < r;i++) {
        n = n->next;
    }
    return n->elem;
}
void print(List* a) {
    Node* n = a->head->next;
    while (n != a->tail) {
        printf("%c", n->elem);
        n = n->next;
    }
    printf("\n");
}
int main(void) {                    //main 함수
    List* a = initializeList();
    int N,count=1;
    scanf("%d", &N);
    for (int i = 0;i < N;i++) {
        char c;
        int d;
        char e;
        scanf(" %c",&c);
        if (c == 'A') {
            scanf("%d %c", &d, &e);
            if (d <= count) {
                add(a, d, e);
                count++;
            }
            else {
                printf("invalid position");
            }
        }
        if (c == 'D') {
            scanf("%d", &d);
            if (d < count) {
                delete(a, d);
                count--;
            }
            else {
                printf("invalid position");
            }
        }
        if (c == 'G') {
            scanf("%d", &d);
            if (d < count) {
                printf("%c\n",get(a, d));
            }
            else {
                printf("invalid position");
            }
        }
        if (c == 'P') {
            print(a);
        }
    }
    return 0;                       //0 반환
}
