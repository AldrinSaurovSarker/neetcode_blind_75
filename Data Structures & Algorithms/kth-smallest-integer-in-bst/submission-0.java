/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int ans = -1;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        infix(root, k);
        return ans;
    }

    public void infix(TreeNode root, int k) {
        if (root.left != null) {
            infix(root.left, k);
        }

        count++;

        if (k == count) {
            ans = root.val;
            return;
        }

        if (root.right != null) {
            infix(root.right, k);
        }
    }
}
