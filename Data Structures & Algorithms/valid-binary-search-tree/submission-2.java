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
    boolean flag = true;

    public boolean isValidBST(TreeNode root) {
        helper(root);
        return flag;
    }

    public int[] helper(TreeNode root) {
        int min = root.val;
        int max = root.val;

        if (root.left != null) {
            int[] left = helper(root.left);
            if (left[1] >= root.val) {
                flag = false;
            }
            min = left[0];
        }

        if (root.right != null) {
            int[] right = helper(root.right);
            if (right[0] <= root.val) {
                flag = false;
            }
            max = right[1];
        }

        return new int[]{min, max};
    }
}
