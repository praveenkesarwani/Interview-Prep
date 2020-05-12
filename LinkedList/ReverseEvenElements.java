/*
Given a singly linked list of integers, reverse every contiguous set of nodes that have only even values.
*/
class Solution {
    public ListNode reverseEvenElements(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (curr.val % 2 != 0 || curr.next == null || curr.next.val % 2 != 0) {
                prev = curr;
                curr = curr.next;
            } else {
                if (curr == head) {
                    head = reverseEvenSublist(prev, curr);
                } else {
                    ListNode oldPrev = prev;
                    oldPrev.next = reverseEvenSublist(prev, curr);
                }
            }
        }
        return head;
    }

    public ListNode reverseEvenSublist(ListNode prev, ListNode curr) {
        ListNode first = curr;
        ListNode temp;
        while (curr != null && curr.val % 2 == 0) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        first.next = curr;
        return prev;
    }
}
