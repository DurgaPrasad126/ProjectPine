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
    public TreeNode invertTree(TreeNode root) {
      if(root == null) return root;

      swapNodes(root);
      return root;
    }
    public void swapNodes(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        swapNodes(root.left);
        swapNodes(root.right);
    }
}