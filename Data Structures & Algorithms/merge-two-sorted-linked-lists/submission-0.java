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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode merged = new ListNode(-1);
        ListNode curr = merged;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                curr.next = ptr1;
                ptr1 = ptr1.next;
            } else {
                curr.next = ptr2;
                ptr2 = ptr2.next;
            }
            curr = curr.next;
        }

        if (ptr1 != null) {
            curr.next = ptr1;
        } else if (ptr2 != null) {
            curr.next = ptr2;
        }

        return merged.next;
    }
}