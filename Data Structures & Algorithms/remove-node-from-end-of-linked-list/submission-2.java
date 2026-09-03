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
        int i = 0;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (i != n) {
            i++;
            fast = fast.next;
        }

        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (slow == head) {
            head = slow.next;
        } else if (slow.next == null) {
            prev.next = null;
        } else {
            prev.next = slow.next;
        }

        return head;
    }
}
