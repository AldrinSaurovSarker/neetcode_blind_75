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
    public Map<Node, Integer> getLookup(Node head) {
        Map<Node, Integer> lookup = new HashMap<>();
        Node temp = head;
        int index = 0;

        while (temp != null) {
            lookup.put(temp, index);
            temp = temp.next;
            index++;
        }
        return lookup;
    }

    public Node copyRandomList(Node head) {
        Node ans = null;
        Node current = null;
        Node temp = head;
        int index = 0;
        ArrayList<Node> arr = new ArrayList<>();

        while (temp != null) {
            Node newNode = new Node(temp.val);
            arr.add(newNode);
            index++;

            if (ans == null) {
                ans = newNode;
                current = ans;
            } else {
                current.next = newNode;
                current = current.next;
            }
            temp = temp.next;
        }

        Node temp1 = head;
        Node temp2 = ans;
        Map<Node, Integer> lookup = getLookup(head);

        while (temp1 != null && temp2 != null) {
            if (lookup.get(temp1.random) != null)
                temp2.random = arr.get(lookup.get(temp1.random));
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return ans;
    }
}
