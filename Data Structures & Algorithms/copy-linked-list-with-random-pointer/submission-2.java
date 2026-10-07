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
    public Node copyRandomList(Node head1) {
        if (head1 == null) return null;

        Node head2 = new Node(head1.val);
        Node temp1 = head1.next;
        Node temp2 = head2;
        Map<Node, Node> map = new HashMap<>();
        map.put(head1, head2);

        while (temp1 != null) {
            Node node = new Node(temp1.val);
            temp2.next = node;
            map.put(temp1, node);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        temp1 = head1;
        temp2 = head2;

        while (temp1 != null) {
            temp2.random = map.get(temp1.random);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return head2;
    }
}
