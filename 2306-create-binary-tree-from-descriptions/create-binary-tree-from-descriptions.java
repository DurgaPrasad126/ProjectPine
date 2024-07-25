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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Integer> leftTreeMap = new HashMap<>();
        Map<Integer, Integer> rightTreeMap = new HashMap<>();
        Set<Integer> indegree = new HashSet<>();
        Set<Integer> nodes = new HashSet<>();
        for(int[] description : descriptions) {
            if(description[2] == 1) leftTreeMap.put(description[0], description[1]);
            else rightTreeMap.put(description[0], description[1]);
            indegree.add(description[1]);
            nodes.add(description[0]);
            nodes.add(description[1]);
        }

        int rootval = 0;
        for(int key : nodes) {
            if(!indegree.contains(key)) {
                rootval = key;
                break;
            }
        }

        TreeNode root = new TreeNode(rootval);

        constructBinaryTree(root, rootval, leftTreeMap, rightTreeMap);
        return root;
    }

    public void constructBinaryTree(TreeNode root, int rootval, Map<Integer, Integer> leftTreeMap, Map<Integer, Integer> rightTreeMap){
        if(root == null) return;

        if(leftTreeMap.containsKey(rootval)) {
            root.left = new TreeNode(leftTreeMap.get(rootval));
            constructBinaryTree(root.left, root.left.val, leftTreeMap, rightTreeMap);
        }
        if(rightTreeMap.containsKey(rootval)) {
            root.right = new TreeNode(rightTreeMap.get(rootval));
            constructBinaryTree(root.right, root.right.val, leftTreeMap, rightTreeMap);
        }
        
    }
}