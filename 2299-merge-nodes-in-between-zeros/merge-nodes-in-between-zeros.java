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
    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode(0);
        ListNode ans = res;
        ListNode temp = head.next;
        while(temp != null) {
            int value = temp.val;
            ListNode temp2 = new ListNode();
            while(temp.val != 0) {
                temp=temp.next;
                value+=temp.val;
            }
            temp2.val = value;
            res.next = temp2;
            res=res.next;

            temp=temp.next;
        }
        return ans.next;
    }
}