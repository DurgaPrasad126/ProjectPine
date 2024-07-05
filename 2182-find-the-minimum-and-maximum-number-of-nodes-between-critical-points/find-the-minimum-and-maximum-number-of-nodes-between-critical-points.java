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

        //ArrayList<Integer> criticalPoints = new ArrayList<>();

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
                //criticalPoints.add(counter);
            }
            prevPointer=prevPointer.next;
            currPointer = currPointer.next;
            counter++;
        }

        /*Collections.sort(criticalPoints);
        int criticSize = criticalPoints.size();
        if(criticSize < 2) return new int[]{-1,-1};
        int minima = Integer.MAX_VALUE;
        int maxima = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for(int i=0;i<criticSize-1;i++) {
            minima = Math.min(minima, criticalPoints.get(i));
            maxima = Math.max(maxima, criticalPoints.get(i));
            minDiff = Math.min(minDiff, criticalPoints.get(i+1)-criticalPoints.get(i));
        }
                    minima = Math.min(minima, criticalPoints.get(criticSize-1));
            maxima = Math.max(maxima, criticalPoints.get(criticSize-1));
            */

            if(firstCritical == -1 || prevCritical == -1 || (firstCritical == prevCritical)) return new int[]{-1,-1};
            
        return new int[]{minDistance, prevCritical-firstCritical};
    }
}