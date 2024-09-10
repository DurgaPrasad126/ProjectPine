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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = head;

        while(head != null && head.next != null) {
            ListNode gcd = new ListNode(gcd(head.val, head.next.val));
            ListNode next = head.next;
            head.next = gcd;
            gcd.next = next;
            head = head.next.next;
        }
        return dummy;
    }

    public int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}