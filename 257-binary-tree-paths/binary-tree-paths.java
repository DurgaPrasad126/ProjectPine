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
        findPaths(root, new StringBuilder());
        return paths;
    }
    public void findPaths(TreeNode root, StringBuilder path) {
        if(root == null) return;
        int n = path.length();
        path.append(root.val);
        if(root.left == null && root.right == null) {
            paths.add(path.toString());
        }
        else{
            path.append("->");
            findPaths(root.left, path);
            findPaths(root.right, path);
        }
        path.setLength(n);
    }
}