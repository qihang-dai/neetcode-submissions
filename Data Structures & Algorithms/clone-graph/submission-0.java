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

/*
Definition for a Node.
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
    public Node cloneGraph(Node node) {

        if(node == null) return null;

        Queue<Node> q = new ArrayDeque<>();
        Map<Node, Node> map = new HashMap<>();

        q.add(node);
        map.put(node, new Node(node.val));

        while(!q.isEmpty()){
            Node cur = q.poll();
            Node newCur = map.get(cur);            

            for(Node n : cur.neighbors){
                if(!map.containsKey(n)){
                    q.add(n);
                    map.put(n, new Node(n.val));
                }
                newCur.neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }

}