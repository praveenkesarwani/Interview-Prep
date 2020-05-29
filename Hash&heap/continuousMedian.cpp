#include <bits/stdc++.h>
using namespace std;

priority_queue<int> max_heap;                            //smaller
priority_queue<int, vector<int>, greater<int>> min_heap; //larger
int findMedian()
{
    if (max_heap.size() == min_heap.size())
    {
        //even elements overall, take average
        return (max_heap.top() + min_heap.top()) / 2;
    }
    //max_heap has one more element than min_heap
    return max_heap.top();
}

vector<int> continuousMedian(int arr[], int n)
{
    vector<int> answer;
    for (int i = 0; i < n; i++)
    {
        int x = arr[i];
        if (max_heap.empty() || max_heap.top() >= x)
            max_heap.push(x);
        else
            min_heap.push(x);
        // it could be that both heaps have equal elements or
        // max_heap has one more element than min_heap
        if (max_heap.size() > min_heap.size() + 1)
        {
            min_heap.push(max_heap.top());
            max_heap.pop();
        }
        else if (max_heap.size() < min_heap.size())
        {
            max_heap.push(min_heap.top());
            min_heap.pop();
        }
        answer.push_back(findMedian());
    }
    return answer;
}
int main()
{
    int n;
    cin >> n;
    int ar[n + 9];
    for (int i = 0; i < n; i++)
        cin >> ar[i];
    vector<int> answer = continuousMedian(ar, n);
    for (auto it : answer)
    {
        cout << it << "\n";
    }
}
