#include<iostream>
#include<vector>
#include<algorithm>
#include<string>

using namespace std;
const int N = 5;

void output(int a[N])
{
        for(int i=0;i<N;i++)
                cout << a[i]<<" ";
        cout << endl;
}

int main()
{
        int a[N] = {2,5,3,1,4};

        sort(a,a+N);
        output(a);

        sort(a,a+N,greater<int>());
        output(a);

        return 0;
}
