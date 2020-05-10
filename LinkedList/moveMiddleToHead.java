/*
Given a singly linked list, find the middle node of the linked list and move that node to the head of the list.
Return the head of the list. In the case of a list with an even number of nodes, use the second middle one.
Input: [2->3->4->5->6->7]
Output: [5->2->3->4->6->7]
*/
class Solution {
    public ListNode moveMiddleToHead(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        slow.next = head;
        head = slow;
        return head;
    }
}
