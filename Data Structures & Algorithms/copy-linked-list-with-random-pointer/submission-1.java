/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node head2 = new Node(0);
        Node temp = head;
        Node temp2 = head2;
        Map<Node, Node> map = new HashMap<>();

        while (temp != null) {
            Node node = new Node(temp.val);
            temp2.next = node;
            map.put(temp, node);
            temp = temp.next;
            temp2 = temp2.next;
        }
        head2 = head2.next;

        temp = head;
        temp2 = head2;

        while (temp != null) {
            temp2.random = map.get(temp.random);
            temp = temp.next;
            temp2 = temp2.next;
        }
        return head2;
    }
}
