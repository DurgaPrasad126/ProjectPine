/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int positionFromLast) {
        ListNode dummy = new ListNode(0);
		 dummy.next = head;
		 
		 int sizeOfLinkedList = findLinkedListSize(head);
		 
		 int posToDelete = sizeOfLinkedList - positionFromLast;
		 int currNodeIndex = 0;
		 
		 if(positionFromLast == sizeOfLinkedList) {
			 dummy.next = head.next;
			 return dummy.next;
		 }
		 
		 while(head.next != null && currNodeIndex != posToDelete-1) {
			 head = head.next;
			 currNodeIndex++;
		 }
		 
		 head.next = (head.next == null) ? null : head.next.next;
		 
		 return dummy.next;
    }

     public static int findLinkedListSize(ListNode head) {
		 int size = 0;
		 while(head != null) {
			 size++;
			 head=head.next;
		 }
		 return size;
	 }
}