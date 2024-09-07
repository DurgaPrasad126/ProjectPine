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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
    if (root == null) return false;
    // Start DFS from the current node or try finding the path starting from left/right subtrees
    return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
}

private boolean dfs(ListNode head, TreeNode root) {
    if (head == null) return true; // Reached the end of the linked list
    if (root == null) return false; // Reached the end of a tree branch without matching the list

    // Match the current node's value and continue DFS if they match
    if (root.val == head.val) {
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }

    return false; // Values don't match
}

}