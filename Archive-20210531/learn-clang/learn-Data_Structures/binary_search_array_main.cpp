#include<iostream>
#include"binary_search_array.h"
using namespace std;

int main()
{
        int a[5] = {1,2,3,4,5};
        cout << binary_search_array(2,a,5) << endl;
        cout << binary_search_array(0,a,5) << endl;
        cout << binary_search_array(2,a+2,5) << endl;
        cout << binary_search_array(0,a,0) << endl;
        return 0;
}
