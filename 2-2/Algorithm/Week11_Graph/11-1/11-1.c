#include <stdio.h>
#include <stdlib.h>

int Graph[7][7];                                //인접배열의 기초가 될 이중배열 선언

void addEdge(int src,int dest,int weight){      //addEdge 함수
    if(src>6||src<1||dest>6||dest<1){           //잘못된 범위면
        printf("-1\n");
        return;                                 //종료
    }
    Graph[src][dest]=weight;                    //배열 수정, 인자를 가중치로 둠
    if(src!=dest){                              //루프가 아니면
        Graph[dest][src]=weight;                //다른쪽도 배열 수정
    }
}
void printNode(int num){                        //printNode 함수
    if(num<=6&&num>=1){                         //옳은 범위 안이면
        int count=0;
        for(int i=0;i<7;i++){
            if(Graph[num][i]!=0){
                printf("%d %d ",i,Graph[num][i]);   //인자가 있으면 오름차순으로 출력
                count=1;
            }
        }
        if(count==0){                           //인자가 없으면
            printf("-1");                       //-1 출력
        }
    }
    else{                                       //범위가 옳지 않으면
        printf("-1");                           //-1 출력
    }
    printf("\n");
}

int main(void) {                                //main 함수
    char c;

    addEdge(1, 2, 1);
    addEdge(1, 3, 1);
    addEdge(1, 4, 1);
    addEdge(1, 6, 2);
    addEdge(2, 3, 1);
    addEdge(3, 5, 4);
    addEdge(5, 5, 4);
    addEdge(5, 6, 3);                        //문제에 나온 그래프 미리 그려주기
    
    while (1) {
        scanf(" %c", &c);
        if (c == 'a') {                         //a 입력되면
            int num;
            scanf("%d", &num);
            printNode(num);                     //printNode 함수 호출
        }
        if (c == 'm') {                         //m 입력되면
            int a, b, w;
            scanf("%d %d %d", &a, &b, &w);
            addEdge(a, b, w);                   //modifyEdge 함수 호출
        }
        if (c == 'q') {                         //q 입력되면
            break;                              //프로그램 종료
        }
    }
    
    return 0;
}
