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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> traversal = new ArrayList<>();
        infix(root, traversal);
        return traversal.get(k - 1);
    }

    public void infix(TreeNode root, List<Integer> traversal) {
        if (root.left != null) {
            infix(root.left, traversal);
        }

        traversal.add(root.val);

        if (root.right != null) {
            infix(root.right, traversal);
        }
    }
}
