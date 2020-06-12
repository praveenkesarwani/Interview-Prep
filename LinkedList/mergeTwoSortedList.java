/*
Given two sorted linked lists, merge them so that the result is also sorted and return the new list.
The new list should be made by putting together the nodes of the first two lists.
*/
class Solution {
    ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {

        ListNode head = l1;
        ListNode tail = l1;
        ListNode temp1 = l1.next;
        ListNode temp2 = l2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                tail.next = temp1;
                tail = temp1;
                temp1 = temp1.next;
            } else {
                tail.next = temp2;
                tail = temp2;
                temp2 = temp2.next;
            }
        }
        if (temp1 != null) {
            tail.next = temp1;
        }
        if (temp2 != null) {
            tail.next = temp2;
        }
        return head;
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val > l2.val) {
            return mergeTwoSortedLists(l2, l1);
        }
        return mergeTwoSortedLists(l1, l2);
    }
}