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
        /*int maxima = 0;
        int minima = Integer.MAX_VALUE;
        int minCritical = Integer.MAX_VALUE;
        int maxCritical = Integer.MIN_VALUE;*/

        ListNode prevPointer = head;
        ListNode currPointer = head.next;

        int counter = 2;

        ArrayList<Integer> criticalPoints = new ArrayList<>();

        while(currPointer.next != null) {
            if((prevPointer.val < currPointer.val && currPointer.val > currPointer.next.val) 
            || (prevPointer.val > currPointer.val && currPointer.val < currPointer.next.val)) {
                criticalPoints.add(counter);
            }
            prevPointer=prevPointer.next;
            currPointer = currPointer.next;
            counter++;
        }
        /*int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        if((minCritical ==  Integer.MAX_VALUE || maxCritical == Integer.MAX_VALUE)) return new int[2]{-1,-1};

        if(minCritical ==  Integer.MAX_VALUE){
            res[0] = maxCritical;
        }
        else if(maxCritical == Integer.MAX_VALUE) res[1] = minCritical;


        return res;*/

        Collections.sort(criticalPoints);

        if(criticalPoints.size() < 2) return new int[]{-1,-1};
        int minima = Integer.MAX_VALUE;
        for(int i=0;i<criticalPoints.size()-1;i++) {
            minima = Math.min(minima, criticalPoints.get(i+1)-criticalPoints.get(i));
        }

        return new int[]{minima, criticalPoints.get(criticalPoints.size()-1)-criticalPoints.get(0)};
    }
}