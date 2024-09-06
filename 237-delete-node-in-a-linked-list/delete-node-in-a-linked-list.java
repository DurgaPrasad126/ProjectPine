/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        int nextVal = node.next.val;
        int delVal = node.val;

        node.next.val = delVal;
        node.val = nextVal;

        node.next = node.next.next;

    }
}