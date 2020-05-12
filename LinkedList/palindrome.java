/*
Check if linked list is a palindrome
*/
class Solution {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode left_head = head; // 1->2->3->2->1->null
        ListNode middle = getMiddleNode(left_head); // 3
        ListNode right_head = middle.next;// 2->1->null
        middle.next = null; // left_head : 1->2->3->null
        right_head = reverseList(right_head); // right_head: 1->2->null

        ListNode left = left_head;
        ListNode right = right_head;
        boolean isPalindrome = true;
        while (left != null && right != null) {
            if (left.val != right.val) {
                isPalindrome = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        right_head = reverseList(right_head); // right_head: 2->1->null
        middle.next = right_head; // head: 1->2->3->2->1->null
        return isPalindrome;
    }

    public static ListNode getMiddleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow_ptr = head;
        ListNode fast_ptr = head;
        while (fast_ptr.next != null && fast_ptr.next.next != null) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }
        return slow_ptr;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        while (curr.next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
}
