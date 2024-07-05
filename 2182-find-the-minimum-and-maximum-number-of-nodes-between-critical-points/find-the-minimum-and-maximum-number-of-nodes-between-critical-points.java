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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
       int firstCritical = -1;
       int prevCritical = -1;
       int minDistance = Integer.MAX_VALUE;

        ListNode prevPointer = head;
        ListNode currPointer = head.next;

        int counter = 2;
        while(currPointer.next != null) {
            if((prevPointer.val < currPointer.val && currPointer.val > currPointer.next.val) 
            || (prevPointer.val > currPointer.val && currPointer.val < currPointer.next.val)) {
                if(firstCritical == -1) {
                    firstCritical = counter;
                    prevCritical = counter;
                }
                else {
                    minDistance = Math.min(minDistance, counter-prevCritical);
                    prevCritical = counter;
                }
            }
            prevPointer=prevPointer.next;
            currPointer = currPointer.next;
            counter++;
        }

        if(firstCritical == -1 || prevCritical == -1 || (firstCritical == prevCritical)) return new int[]{-1,-1};
            
        return new int[]{minDistance, prevCritical-firstCritical};
    }
}