/*
Write an algorithm to find the Kth element in the array such that their only prime factors are 3,5 an 7. Note that 3,5, 
and 7 do not have to be factors, but it should not have any other prime factors.

Example: Such an array would contain 1,3,5,7,9,15,21,25,…

We have to return the Kth element in the array.
input:6
output:15
*/
#include <bits/stdc++.h>
using namespace std;
long long minimum(long long x, long long y)
{
    return x < y ? x : y;
}
long long kthMultiple(long long k)
{
    long long x = 1;
    queue<long long int> q3, q5, q7;
    for (int i = 1; i < k; i++)
    {
        q3.push(x * 3);
        q5.push(x * 5);
        q7.push(x * 7);
        x = minimum(q3.front(), (q5.front()));
        x = minimum(x, q7.front());
        if (x == q3.front())
            q3.pop();
        if (x == q5.front())
            q5.pop();
        if (x == q7.front())
            q7.pop();
    }
    return x;
}

int main()
{
    long long k = 10;
    cin >> k;
    long long x = kthMultiple(k);
    cout << x << endl;
    return 0;
}