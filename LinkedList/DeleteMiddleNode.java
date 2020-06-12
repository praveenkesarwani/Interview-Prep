/*
Write a program to delete a node in the middle 
(not first or last node) of a singly linked list, given access only to that node
*/
class Solution {
    public static void deleteMiddleNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }
}
//Time Complexity: O(1)
//Space Complexity:O(1)