/*
Write code to partition a linked list around a value X, such that all nodes less than X come
before all nodes greater than X. If X is contained within the list, then those nodes need
to be after the elements less than X and before the elements greater than X,
i.e. they should appear between the left and right partitions.
*/
class Solution
{
    ListNode *partition(ListNode *head, int x)
    {
        ListNode *temp = head;
        ListNode *left_head = NULL;
        ListNode *left_tail = NULL;
        ListNode *right_head = NULL;
        ListNode *right_tail = NULL;
        while (temp != NULL)
        {
            if (temp->val < x)
            {
                ListNode *newNode = new ListNode(temp->val);
                if (left_head == NULL)
                {
                    left_head = newNode;
                    left_tail = newNode;
                }
                else
                {
                    newNode->next = left_head;
                    left_head = newNode;
                }
            }
            else if (temp->val == x)
            {
                ListNode *newNode = new ListNode(temp->val);
                if (left_head == NULL)
                {
                    left_head = newNode;
                    left_tail = newNode;
                }
                else
                {
                    left_tail->next = newNode;
                    left_tail = newNode;
                }
            }
            else
            {
                ListNode *newNode = new ListNode(temp->val);
                if (right_head == NULL)
                {
                    right_head = newNode;
                    right_tail = newNode;
                }
                else
                {
                    right_tail->next = newNode;
                    right_tail = newNode;
                }
            }
            temp = temp->next;
        }
        left_tail->next = right_head;

        return left_head;
    }
}