/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> oldNewMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return node;

        return deepCopy(node);
    }

    public Node deepCopy(Node orig) {
        if(oldNewMap.containsKey(orig)) return oldNewMap.get(orig);
        Node copy = new Node(orig.val);
        oldNewMap.put(orig, copy);
        for(Node origNbr : orig.neighbors) {
            copy.neighbors.add(deepCopy(origNbr));
        }
        return copy;
    }
}