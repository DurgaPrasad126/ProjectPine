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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevPtr = dummy;
        ListNode iterator = dummy.next;

        while(iterator != null) {
            if(set.contains(iterator.val)) {
                ListNode nextPtr = iterator.next;
                //iterator.next = null;
                //System.out.println(prevPtr.val);
                prevPtr.next = nextPtr;
            }
            else {
                prevPtr=prevPtr.next;
            }
            iterator = iterator.next;
        }
        return dummy.next;
    }
}