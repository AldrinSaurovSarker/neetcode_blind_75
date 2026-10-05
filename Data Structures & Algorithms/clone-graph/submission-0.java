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
        if (node == null) {
            return null;
        }

        Deque<Node> queue = new ArrayDeque<>();
        Map<Node, Node> copiedMap = new HashMap<>();

        queue.offer(node);
        copiedMap.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node copied = copiedMap.get(current);

            for (Node neighbor : current.neighbors) {
                if (!copiedMap.containsKey(neighbor)) {
                    copiedMap.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }

                copied.neighbors.add(copiedMap.get(neighbor));
            }
        }

        return copiedMap.get(node);
    }
}