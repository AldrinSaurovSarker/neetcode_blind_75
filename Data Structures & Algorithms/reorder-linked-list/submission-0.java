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
    public void reorderList(ListNode head) {
        List<ListNode> arr = new ArrayList<>();

        ListNode temp = head;

        while (temp != null) {
            arr.add(temp);
            temp = temp.next;
        }

        int left = 1;
        int right = arr.size() - 1;

        temp = head;
        int turn = 1;

        while (left <= right) {
            if (turn == 1) {
                temp.next = arr.get(right);
                right--;
            } else {
                temp.next = arr.get(left);
                left++;
            }
            temp = temp.next;
            turn *= -1;
        }

        temp.next = null;
    }
}
