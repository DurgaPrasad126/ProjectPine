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
    List<String> paths;
    public List<String> binaryTreePaths(TreeNode root) {
        paths = new ArrayList<>();
        findPaths(root, "");
        return paths;
    }
    public void findPaths(TreeNode root, String path) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            path+=root.val;
            paths.add(path);
        }
        else {
            path+=root.val;
            path+="->";
            findPaths(root.left, path);
            findPaths(root.right, path);
        }
    }
}