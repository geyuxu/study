#include<iostream>
#include<vector>
using namespace std;
int main()
{
    const int n = 42;
    const int c = 1;

    int A1[n];
    vector<int> v1(n);

    for(int i=0;i<n;++i)
            A1[i] = c;
    vector<int> v2(n,c);

    vector<int> v3 = {1,2,3,4,5};
    for(size_t i=0;i<v3.size();++i)
            cout << v3[i] << " ";
    cout << endl;

    v3.push_back(6);
    cout << v3.size() << endl;
    cout << v3.front() << " " << v3.back() << endl;

    v3.pop_back();
    cout << v3.size() << endl;
    cout << v3.front() << " " << v3.back() << endl;

    for(auto iter = v3.begin(); iter != v3.end(); ++iter)
            cout << *iter << " ";
    cout << endl;

    return 0;
}
