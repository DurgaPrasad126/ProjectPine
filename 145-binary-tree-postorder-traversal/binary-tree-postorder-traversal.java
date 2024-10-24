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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        //computePostorder(root, result);
         List<Integer> postOrder = new ArrayList<>();
        //postOrderTraverse(root, postOrder);
        Stack<TreeNode> postStack = new Stack<>();
        postStack.push(root);
        while(!postStack.isEmpty()) {
            TreeNode curNode = postStack.pop();
            if(curNode.left != null) postStack.push(curNode.left);
            if(curNode.right != null) postStack.push(curNode.right);
            postOrder.add(curNode.val);
        }
        Collections.reverse(postOrder);
        return postOrder;
    }

    public void computePostorder(TreeNode root, List<Integer> result) {
        if(root == null) return;
        computePostorder(root.left, result);
        computePostorder(root.right, result);
        result.add(root.val);

    }
}
