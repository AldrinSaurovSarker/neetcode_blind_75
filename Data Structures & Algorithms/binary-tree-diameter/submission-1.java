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
    public int diameterOfBinaryTree(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }

        int leftHeight = diameterOfBinaryTree(root.left, max);
        int rightHeight = diameterOfBinaryTree(root.right, max);
        max[0] = Math.max(max[0], leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        diameterOfBinaryTree(root, max);
        return max[0];
    }
}
