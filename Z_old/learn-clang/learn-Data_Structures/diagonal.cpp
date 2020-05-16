#include<iostream>
using namespace std;

const int n = 64;

void output(int M[n][n]){
        for(int i=0;i<n;++i){
                for(int j=0;j<n;++j)
                        cout << M[i][j];
                cout << endl;
        }
}

void func1(int M[n][n],int x,int y){
        for(int i=0;i<n;++i)
                for(int j=0;j<n;++j)
                        if(i==j)
                                M[i][j] = x;
                        else
                                M[i][j] = y;
}

void func2(int M[n][n],int x,int y){
        for(int i=0;i<n;++i)
                for(int j=0;j<n;++j)
                        M[i][j] = y;
        for(int i=0;i<n;++i)
                M[i][i] = x;

}

int main()
{
        int x = 4;
        int y = 2;
        int M[n][n];

        //func1(M,x,y);
        func2(M,x,y);
        
        output(M);
                                
        return 0;
}
