/*
Given the head to singly Linked List and a number K, 
rotate the list right by K nodes. Assume K is non-negative.
*/
class Solution
{
    pair<int, ListNode *> lengthOfList(ListNode *head)
    {
        ListNode *tail = head;
        int length = 1;
        pair<int, ListNode *> ans;
        while (tail->next != NULL)
        {
            length++;
            tail = tail->next;
        }
        ans.first = length;
        ans.second = tail;
        return ans;
    }

    ListNode *rotateList(ListNode *head, int k)
    {
        pair<int, ListNode *> pairOfLengthAndTail = lengthOfList(head);
        int length = pairOfLengthAndTail.first;
        ListNode *tail = pairOfLengthAndTail.second;
        k = k % length;
        if (k == 0)
        {
            return head;
        }
        ListNode *temp = head;
        for (int i = 1; i < length - k; i++)
        {
            temp = temp->next;
        }
        ListNode *newHead = temp->next;
        temp->next = NULL;
        tail->next = head;
        return newHead;
    }
}