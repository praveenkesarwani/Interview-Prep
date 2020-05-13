/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list. is a positive integer and is less than or equal to
 * the length of the linked list. If the number of nodes is not a multiple of k
 * then left-out nodes in the end should remain as it is.
 */
class Solution {
    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = head.next;
        while (curr.next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode start = head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        int k1 = k;
        while (curr != null) {
            prev = curr;
            curr = curr.next;
            k1--;
            if (k1 == 0) {
                prev.next = null;
                if (newHead == null) {
                    newHead = reverse(head);
                    newTail = head;
                } else {
                    newTail.next = reverse(start);
                    newTail = start;
                }
                start = curr;
                prev = curr;
                if (curr != null)
                    curr = curr.next;
                k1 = k - 1;
            }
        }
        if (newTail != null)
            newTail.next = start;
        return newHead;
    }
}