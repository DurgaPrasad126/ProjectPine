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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode dummy = head;
        int size = 0;
        while(dummy!= null) {
            size++;
            dummy=dummy.next;
        }
        int rem = size%k;
        ListNode[] res = new ListNode[k];
        int pos = 0;
        while(head != null) {
            int len = size/k + (rem > 0 ? 1 : 0);
            ListNode prev = head;
            ListNode list = prev;
            while(head != null && len > 0) {
                --len;
                prev = head;
                head = head.next;
            }
            if(prev != null) prev.next = null;
            res[pos++] = list;
            rem--;
        }
        return res;
        
    }
}