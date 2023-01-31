//
// Created by Yasin Gee on 2019-08-28.
//
#include <stdio.h>
#include <stdlib.h>

#define ListSize 100
typedef int DataType;
typedef struct
{
    DataType data[ListSize];
    int length;
} SeqList;

void InsertList(SeqList *L,int i,DataType x)
{
    int j;
    if(i<1||i>L->length+1)
    {
        printf("position error");
        return;
    }
    if(L->length>ListSize){
        printf("overflow");
        return;
    }
    for(j=L->length-1;j>=i-1;j--){
        L->data[j+1]=L->data[j];
    }
    L->data[i-1]=x;
    L->length++;
}

DataType DeleteList(SeqList *L,int i){
    int j;
    DataType x;
    if(i<1||i>L->length){
        printf("position error");
        exit(0);
    }
    x=L->data[i];
    for(j=i;j<=L->length;j++){
        L->data[j-1]=L->data[j];
    }
    L->length--;
    return x;
}

SeqList Converts(SeqList L){
    DataType x;
    int i,k;
    k=L.length/2;
    for(i=0;i<k;i++){
        x=L.data[i];
        L.data[i] = L.data[L.length-i-1];
        L.data[L.length-i-1] = x;
    }
    return L;
}

void MaxMin(SeqList L,DataType *max,DataType *min,int *k,int *j){
    int i;
    *max = L.data[0];
    *min = L.data[0];
    *k=*j=1;
    for(i=1;i<L.length;i++){
        if(L.data[i] > *max){
            *max = L.data[i];
            *k=i;
        }else if(L.data[i] < *min){
            *min = L.data[i];
            *j = i;
        }
    }
}
