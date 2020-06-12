//Reverse a doubly linked list
class Solution {
    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        DoublyLinkedListNode curr = head;
        DoublyLinkedListNode prev = null;
        DoublyLinkedListNode next = head.next;
        while (curr.next != null) {
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        return curr;
    }
}