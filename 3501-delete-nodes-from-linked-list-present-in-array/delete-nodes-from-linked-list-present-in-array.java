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
        /*
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevPtr = dummy;
        ListNode iterator = dummy.next;

        while (iterator != null && set.contains(iterator.val)) {
            iterator = iterator.next;
        }
        prevPtr.next = iterator;

        if (iterator == null) {
            return null;
        }

        while(iterator != null) {
            if(set.contains(iterator.val)) {
                prevPtr.next = iterator.next;
            }
            else {
                prevPtr=prevPtr.next;
            }
            iterator = iterator.next;
        }
        return dummy.next;
        */

         Set<Integer> valuesToRemove = new HashSet<>();
        for (int num : nums) {
            valuesToRemove.add(num);
        }

        // Handle the case where the head node needs to be removed
        while (head != null && valuesToRemove.contains(head.val)) {
            head = head.next;
        }

        // If the list is empty after removing head nodes, return null
        if (head == null) {
            return null;
        }

        // Iterate through the list, removing nodes with values in the set
        ListNode current = head;
        while (current.next != null) {
            if (valuesToRemove.contains(current.next.val)) {
                // Skip the next node by updating the pointer
                current.next = current.next.next;
            } else {
                // Move to the next node
                current = current.next;
            }
        }

        return head;
    }
}