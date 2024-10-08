/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        naryPostOrder(root, res);
        return res;
    }

    public void naryPostOrder(Node root, List<Integer> res) {
        if(root == null) return;
        //if(root.children == null || root.children.size() == 0) res.add(root.val);

        for(Node child : root.children) {
            naryPostOrder(child, res);
        }
        res.add(root.val);
    }

}