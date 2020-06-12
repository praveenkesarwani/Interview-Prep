
/*
// Definition for ListNode
class ListNode {
public:
    int val;
    ListNode* next;
    ListNode() {}
    ListNode(int x) {
        val = x;
        next = NULL;
    }
};
*/

class Solution
{
public:
    ListNode *mergeKSortedList(vector<ListNode *> lists)
    {
        // edge case
        if (lists.size() == 0)
            return NULL;
        // create a min_heap and insert values of every list node
        priority_queue<int, vector<int>, greater<int>> pq;
        for (int i = 0; i < lists.size(); i++)
        {
            ListNode *head = lists[i];
            //if head of lists[i] is NULL check for next list
            if (head == NULL)
                continue;
            while (head != NULL)
            {
                pq.push(head->val);
                head = head->next;
            }
        }
        //if every list is null
        if (pq.empty())
            return NULL;
        // Initialize head and tail of output with top of pq (that is minimum)
        ListNode *head = new ListNode(pq.top());
        ListNode *tail = head;
        pq.pop();
        //for every node make a new node with top value of heap and add
        //it to next to the tail and update tail
        while (!pq.empty())
        {
            ListNode *newNode = new ListNode(pq.top());
            tail->next = newNode;
            tail = newNode;
            pq.pop();
        }
        //return head of resultant list
        return head;
    }
};