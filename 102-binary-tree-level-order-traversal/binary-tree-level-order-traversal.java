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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> lvlOrder = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        lvlOrder.offer(root);
        while(!lvlOrder.isEmpty()) {
            List<Integer> lvl = new ArrayList<>();
            int size = lvlOrder.size();
            for(int i=0;i<size;i++){
                TreeNode curNode = lvlOrder.poll();
                lvl.add(curNode.val);
                if(curNode.left != null) lvlOrder.offer(curNode.left);
                if(curNode.right != null) lvlOrder.offer(curNode.right);
            }
            res.add(lvl);
        }
        return res;
    }
}