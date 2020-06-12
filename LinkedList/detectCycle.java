/*
Given a linked list, return the node where the cycle begins.If there is no cycle, return null.
or
Find the starting node of a linked list cycle if it has cycle
*/
public class Solution {
    ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode cycleNode = hasCycle(head);
        if (cycleNode != null) {
            ListNode newNode = head;
            while (newNode != cycleNode) {
                newNode = newNode.next;
                cycleNode = cycleNode.next;
            }
            return newNode;
        }
        return null;
    }
}