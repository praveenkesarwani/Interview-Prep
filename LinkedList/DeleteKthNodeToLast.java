/*
Given a singly linked list of integers, find and remove the Kth node from the end and 
return the head of the linked list
*/
class Solution {
    public static ListNode deleteKthToLast(ListNode head, int k) {
        ListNode first_ptr = head;
        ListNode second_ptr = head;
        while (k > 0) {
            second_ptr = second_ptr.next;
            k--;
        }
        if (second_ptr == null) { // single headed list or k = length
            first_ptr = first_ptr.next;
            return first_ptr;
        }
        while (second_ptr.next != null) {
            first_ptr = first_ptr.next;
            second_ptr = second_ptr.next;
        }
        first_ptr.next = first_ptr.next.next;
        return head;
    }
}