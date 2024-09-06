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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode iterator = dummy;

        while(iterator != null && iterator.next != null) {
            if(iterator.next.val == val) {
                iterator.next = iterator.next.next;
            }
            else iterator = iterator.next;
        }
        

        return dummy.next;
    }
}