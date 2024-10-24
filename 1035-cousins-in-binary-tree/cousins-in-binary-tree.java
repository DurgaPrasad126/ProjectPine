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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(x == root.val || y == root.val) return false;
        int[] xParent = new int[2];
        int[] yParent = new int[2];
        findParent(root, x, xParent, 0);
        findParent(root, y, yParent, 0);
        //System.out.println(xParent[0] + " --- " + xParent[1]);
        //System.out.println(yParent[0] + " --- " + yParent[1]);
        return (xParent[1] == yParent[1]) && (xParent[0] != yParent[0]);
    }

    public void findParent(TreeNode root, int node, int[] parent, int depth) {
        if(root == null) return;
        if((root.left != null && root.left.val == node) || (root.right != null && root.right.val == node)) {
            //parent = new int[]{root.val, depth};
            parent[0] = root.val;
            parent[1] = depth;
            //System.out.println("visited" + " " + root.val + " " + depth);
            return;
        }
        findParent(root.left, node, parent, depth+1);
        findParent(root.right, node, parent, depth+1);
    }
}