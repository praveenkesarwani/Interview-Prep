/*
Given the head nodes of two singly linked lists which may or may not intersect, find if they intersect and 
if they do intersect, return the intersection node. If they don’t intersect, return null. 
Do this in O(M+N) time, where M and N are the sizes of the two lists and O(1) space.

Input: [3->1->7->9->15->7] and [2->6->9->15->7]
Output: 9
*/
class Solution {
    public static int calculateLength(ListNode head){
        ListNode temp = head;
        int length = 0;
        while(temp != null){
            temp = temp.next;
            length++;
        }
        return length;
    }
    public static ListNode updateHead(ListNode head, int diff){
        while(diff > 0){
            head = head.next;
            diff--;
        }
        return head;
    }
    public static ListNode intersection(ListNode head1, ListNode head2){
        while(head1 != null && head2 != null){
            if(head1 == head2){
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
	public static ListNode listIntersectionPoint(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        ListNode head2 = headB;
        int length1 = calculateLength(headA); //6
        int length2 = calculateLength(headB); //5
        int diff = Math.abs(length1 - length2); //1
        if(length1 > length2){
            head1 = updateHead(head1 , diff); // head = 1 (node)
        }
        else{
            head2 = updateHead(head2, diff);
        }
        return intersection(head1,head2);
    }
}
// 3->1->7->9->15->7
// 2->6->9->15->7