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
    public ListNode reverseList(ListNode head) {
        ListNode head2 = null;

        ListNode temp = head;
        while (temp != null) {
            ListNode newNode = new ListNode(temp.val);

            if (head2 == null) {
                head2 = newNode;
            } else {
                newNode.next = head2;
                head2 = newNode;
            }
            temp = temp.next;
        }
        return head2;
    }
}
