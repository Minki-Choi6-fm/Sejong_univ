#include <stdio.h>
#include <stdlib.h>
#include <string.h>                 //헤더 선언

typedef struct Node {                //구조체 선언
    int elem;
    struct Node* left;
    struct Node* right;
}Node;

Node* tree=NULL;

Node *insertNode(int data){
    Node *node=(Node*)malloc(sizeof(Node));
    node->elem=data;
    node->left=NULL;
    node->right=NULL;
    return node;
}

void insertChildNode(Node *node,int left,int right){
    if(left!=0){
        Node *l_node=insertNode(left);
        node->left=l_node;
    }
    if(right!=0){
        Node *r_node=insertNode(right);
        node->right=r_node;
    }
}

Node *preOrder(Node *node,int data){
    if(node==NULL)return NULL;
    if(node->elem==data){
        return node;
    }
    Node *l_node=preOrder(node->left,data);
    if(l_node!=NULL)return l_node;
    return preOrder(node->right,data);
}

void insertTree(int data,int left,int right){
    if(tree==NULL){
        Node *node=insertNode(data);
        insertChildNode(node,left,right);
        tree=node;
    }
    else{
        Node *node=tree;
        node=preOrder(node,data);
        insertChildNode(node,left,right);
    }
}

void search(Node* node,char str[101],int i){
    if(node==NULL){
        return;
    }
    printf(" %d",node->elem);
    if(str[i]=='L'){
        search(node->left,str,i+1);
    }
    if(str[i]=='R'){
        search(node->right,str,i+1);
    }
}

int main(void){
    int n,m;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        int data,left,right;
        scanf("%d %d %d",&data,&left,&right);
        insertTree(data,left,right);
    }
    scanf("%d",&m);
    for(int i=0;i<m;i++){
        char str[101];
        scanf(" %s",str);
        search(tree,str,0);
        printf("\n");
    }
}
