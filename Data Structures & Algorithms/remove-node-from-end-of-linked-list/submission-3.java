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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode left = head;
        ListNode right = head;

        for (int i=1; i<=n; i++) right = right.next;

        while (right != null) {
            prev = left;
            left = left.next;
            right = right.next;
        }

        if (prev != null) {
            prev.next = left.next;
            return head;
        } else
            return head.next;
    }
}
