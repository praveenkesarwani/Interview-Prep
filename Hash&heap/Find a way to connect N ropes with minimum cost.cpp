/*
You are given N ropes of varying lengths. 
The cost of connecting any two ropes is equal to the sum of their lengths. 
Your goal is to connect all N ropes together to form a single rope and minimize the cost in the process.
*/

long long connectRopes(vector<long long > arr)
{
    long long cost = 0;
    //create min_heap
    priority_queue<long long, vector<long long>,greater<long long>> pq;
    // push all elements of arr into min_heap
    for(int rope: arr)
        pq.push(rope);
    while(pq.empty() > 1){
        //pop two elements from pq and add them
        long long rope1 = pq.top(); 
        pq.pop();
        long long rope2 = pq.top();
        pq.pop();
        long long sum = rope1 + rope2;
        cost += sum;
        pq.push(sum);
    }
    return cost;
}
/**
*Time complexity : O(n log n) because heapify (called while extraction and insertion) 
    takes O(log n) time and it will be called proportional to the number of elements n.
*Space complexity is O(n) for the heap.
*/