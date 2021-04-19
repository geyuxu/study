#include<iostream>
using namespace std;
/*
 * 分别用while，do-while，for三种方式实现1000以内自然数，所有7的倍数的和
 */

int funcWhile();
int funcDoWhile();
int funcFor();

int main(){
    
    cout << funcWhile() << endl;
    cout << funcDoWhile() << endl;
    cout << funcFor() << endl;
    return 0;
}

int funcWhile(){
    int result = 0;
    int n=1;
    while(n<=1000){
       if(n%7 == 0){
           result += n;
       } 
       n++;
    }
    return result;
}

int funcDoWhile(){
    int result = 0;
    int n=1;
    do{
       if(n%7 == 0){
           result += n;
       } 
       n++;
    }while(n<=1000);
    return result;
}

int funcFor(){
    int result = 0;
    for(int i=1;i<=1000;i++){
        if(i%7==0){
            result += i;
        }
    }
    return result;
}