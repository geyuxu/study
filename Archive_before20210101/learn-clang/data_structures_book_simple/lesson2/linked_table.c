//
// Created by Yasin Gee on 2019-08-28.
//
#include <stdio.h>
#include <stdlib.h>
typedef int DataType;

typedef struct node{
    DataType data;
    struct node *next;
}ListNode;

typedef ListNode *LinkList;
ListNode *p;
LinkList head;

int main()
{
    printf("Hello, World linked!\n");
    return 0;
}