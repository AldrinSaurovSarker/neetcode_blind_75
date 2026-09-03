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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        int carry = 0;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            current.next = new ListNode(sum % 10);
            carry = sum/10;

            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            current.next = new ListNode(sum % 10);
            carry = sum/10;

            current = current.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            current.next = new ListNode(sum % 10);
            carry = sum/10;

            current = current.next;
            l2 = l2.next;
        }

        if (carry == 1) {
            current.next = new ListNode(1);
        }

        return head.next;
    }
}
