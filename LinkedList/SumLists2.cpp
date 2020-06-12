/*
You’re given two numbers represented by two linked lists, where each node contains a single digit. 
The digits are stored in forward order i.e the ones digit is at the tail of the list. 
Write a function that adds the two numbers and returns the sum as a linked list in the same order.
*/
ckass Solution
{
    stack<int> createStack(ListNode * head)
    {
        stack<int> s;
        ListNode *temp = head;
        while (temp != NULL)
        {
            s.push(temp->val);
            temp = temp->next;
        }
        return s;
    }
    ListNode *addTwoNumbers(stack<int> s1, stack<int> s2)
    {
        ListNode *head = NULL;
        int carry = 0;
        int number = 0;
        while (!s2.empty())
        {
            number = s1.top() + s2.top() + carry;
            carry = number / 10;
            ListNode *newNode = new ListNode(number % 10);
            if (head == NULL)
            {
                head = newNode;
            }
            else
            {
                newNode->next = head;
                head = newNode;
            }
            s1.pop();
            s2.pop();
        }
        while (!s1.empty())
        {
            number = s1.top() + carry;
            carry = number / 10;
            ListNode *newNode = new ListNode(number % 10);
            newNode->next = head;
            head = newNode;
            s1.pop();
        }
        if (carry != 0)
        {
            ListNode *newNode = new ListNode(carry);
            newNode->next = head;
            head = newNode;
        }
        return head;
    }
    ListNode *sumLists2(ListNode * head1, ListNode * head2)
    {
        if (head1 == NULL)
        {
            return head2;
        }
        if (head2 == NULL)
        {
            return head1;
        }
        stack<int> s1 = createStack(head1);
        stack<int> s2 = createStack(head2);
        if (s1.size() > s2.size())
        {
            return addTwoNumbers(s1, s2);
        }
        return addTwoNumbers(s2, s1);
    }
}