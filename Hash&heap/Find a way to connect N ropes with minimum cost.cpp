/*
You are given N ropes of varying lengths. 
The cost of connecting any two ropes is equal to the sum of their lengths. 
Your goal is to connect all N ropes together to form a single rope and minimize the cost in the process.
*/

#include <bits/stdc++.h>
using namespace std;

long long connectRopes(vector<long long > arr)
{
    long long cost = 0;
    //edge case
    if(arr.size() == 1)
        return cost;
    //create min_heap
    priority_queue<long long, vector<long long>,greater<long long>> pq;
    // push all elements of arr into min_heap
    for(int rope: arr)
        pq.push(rope);
    while(!pq.empty()){
        //pop two elements from pq and add them
        long long rope1 = pq.top(); 
        pq.pop();
        long long rope2 = pq.top();
        pq.pop();
        long long sum = rope1 + rope2;
        cost += sum;
        //when all elements are popped
        if(!pq.empty())
            pq.push(sum);
    }
    return cost;
}

int main()
{
    int n;
    cin>>n;
    vector<long long > arr(n);
    for(int i=0;i<n;i++)
        cin>>arr[i];
    long long result = connectRopes(arr);
    cout<<result<<"\n";
    return 0;
}
