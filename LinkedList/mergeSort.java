/*
Given a singly linked list containing N integers, sort it in O(NlogN) time.
*/
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddleNode(head);
        ListNode middle_plus_one = middle.next;
        middle.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(middle_plus_one);
        ListNode sorted_list = mergeSort(left, right);
        return sorted_list;
    }

    public ListNode getMiddleNode(ListNode head) {
        if (head == null) {
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

    public ListNode mergeSort(ListNode left, ListNode right) {
        // use a dummy node to track the start of the list
        ListNode dummy_node = new ListNode(0);
        ListNode prev = dummy_node;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        // Append the rest of the list from the half that is not null
        if (left == null) {
            prev.next = right;
        } else {
            prev.next = left;
        }
        return dummy_node.next;
    }
}
