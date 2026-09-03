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
    public int diameterOfBinaryTree(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return 0;
        }

        int leftHeight = diameterOfBinaryTree(root.left, arr);
        int rightHeight = diameterOfBinaryTree(root.right, arr);
        arr.add(leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        diameterOfBinaryTree(root, arr);

        int max = 0;
        for (int diam : arr) {
            max = Math.max(max, diam);
        }
        return max;
    }
}
