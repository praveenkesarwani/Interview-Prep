//Write a program to insert a value in a singly linked sorted circular list,
//given access to one of the nodes
//Input: [5->8->2] and Pointer to node [5] is given. Insert value [7].
//Output: [5->7->8->2]
class Solution {
    public ListNode insertIntoSortedCircularList(ListNode head, int insertVal) {
        ListNode node = new ListNode(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        ListNode minHead = null;
        ListNode tail = head;
        while (tail.val < tail.next.val) {
            tail = tail.next;
        }
        minHead = tail.next;
        // 5->8->2 is now treated as 2->5->8
        // if inserVal is minimum or maximum
        if (insertVal < minHead.val || insertVal > tail.val) {
            node.next = tail.next;
            tail.next = node;
            return head;
        }
        // if insertVal is somewhere in middle
        ListNode curr = minHead;
        while (curr.next.val < insertVal) {
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
        return head;
    }
}