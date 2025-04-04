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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, LinkedHashSet<TreeNode>> parentMap = new HashMap<>();
        Map<Integer, Set<TreeNode>> levelOrder = new HashMap<>();
        TreeNode dummy = root;
        Queue<TreeNode> q = new LinkedList<>();
        parentMap.put(root, new LinkedHashSet<>());
        q.offer(dummy);
        int depth = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode cur = q.poll();
                levelOrder.computeIfAbsent(depth, l -> new HashSet<>()).add(cur);

            // If current node has a left child
            if (cur.left != null) {
                // Create a new set for the left child and add current node as its parent
                parentMap.computeIfAbsent(cur.left, k -> new LinkedHashSet<>(parentMap.get(cur)));
                parentMap.get(cur.left).add(cur);
                q.offer(cur.left);
            }

            // If current node has a right child
            if (cur.right != null) {
                // Create a new set for the right child and add current node as its parent
                parentMap.computeIfAbsent(cur.right, k -> new LinkedHashSet<>(parentMap.get(cur)));
                parentMap.get(cur.right).add(cur);
                q.offer(cur.right);
            }
            }
            depth++;
        }

        depth-=1;

        List<TreeNode> deepestNodes = new ArrayList<>(levelOrder.get(depth));
        for(int i=0;i<deepestNodes.size();i++)        System.out.println(deepestNodes.get(i).val);

        if(deepestNodes.size()==1) return deepestNodes.get(0);
        LinkedHashSet<TreeNode> deepNodes = parentMap.get(deepestNodes.get(0));
        for(TreeNode node : deepNodes) {
            System.out.print(node.val + " ---- ");
        }
        for(int i=1;i<deepestNodes.size();i++) {
            deepNodes.retainAll(parentMap.get(deepestNodes.get(i)));
        }
        TreeNode lastEle = root;
        if(deepNodes == null || deepNodes.size() == 0) return root;
        Iterator<TreeNode> res = deepNodes.iterator();
        while(res.hasNext()) {
            lastEle = res.next();
        }
        return lastEle;
    }
}