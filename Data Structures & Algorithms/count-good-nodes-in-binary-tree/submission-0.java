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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int good = 0;
        if (max <= root.val) {
            max = root.val;
            good++;
        }

        return good + goodNodes(root.left, max) + goodNodes(root.right, max);
    }
}
