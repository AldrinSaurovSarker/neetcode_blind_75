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

 // 1 => 2 => 3
 // 
 // 
 // 

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            ListNode temp = curr.next.next;
            curr.next.next = head;
            head = curr.next;
            curr.next = temp;
        }
        return head;
    }
}
