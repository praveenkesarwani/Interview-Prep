/*
Given a sorted singly linked list of integers, delete all nodes that have duplicates in the list.
This effectively leaves the list with only numbers that were distinct in the input array. 
Return the head of the sorted linked list after duplicate removal.
*/
class Solution {
    public static ListNode removeDuplicatesFromList(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }
        ListNode result_head = null;
        ListNode result_tail = null;
        temp = head;
        while (temp != null) {
            if (map.get(temp.val) == 1) {
                if (result_head == null) {
                    result_head = temp;
                    result_tail = temp;
                } else {
                    result_tail.next = temp;
                    result_tail = temp;
                }
            }
            temp = temp.next;
        }
        if (result_tail != null) {
            result_tail.next = null;
        }
        return result_head;
    }
}