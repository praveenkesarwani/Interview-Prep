/*
Convert singly linked list to doubly linked circular list
*/
class Solution
{
    DoublyLinkedListNode *doublyLinkedCircularList(ListNode *head)
    {
        if (head == NULL)
        {
            return NULL;
        }
        if (head->next == NULL)
        {
            DoublyLinkedListNode *output = new DoublyLinkedListNode(head->val);
            output->next = output;
            output->prev = output;
            return output;
        }
        DoublyLinkedListNode *output_head = NULL;
        DoublyLinkedListNode *output_tail = NULL;
        ListNode *curr = head;
        while (curr != NULL)
        {
            if (output_head == NULL)
            {
                DoublyLinkedListNode *newNode = new DoublyLinkedListNode(curr->val);
                output_head = newNode;
                output_tail = newNode;
            }
            else
            {
                DoublyLinkedListNode *newNode = new DoublyLinkedListNode(curr->val);
                newNode->prev = output_tail;
                output_tail->next = newNode;
                output_tail = newNode;
            }
            curr = curr->next;
        }
        output_head->prev = output_tail;
        output_tail->next = output_head;
        return output_head;
    }
}
