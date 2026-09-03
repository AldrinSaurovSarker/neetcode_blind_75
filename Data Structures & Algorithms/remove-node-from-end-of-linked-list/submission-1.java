/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;

        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        int pos = getLength(head) - n;
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (i == pos) {
                if (current == head) {
                    head = current.next;
                } else if (current.next == null) {
                    prev.next = null;
                } else {
                    prev.next = current.next;
                }
                break;
            }

            i++;
            prev = current;
            current = current.next;
        }
        return head;
    }
}
