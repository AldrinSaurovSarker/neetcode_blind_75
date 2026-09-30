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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        inorderTraversal(root, ans);
        return ans;
    }

    public void inorderTraversal(TreeNode root, List<Integer> ans) {
        if (root.left != null) inorderTraversal(root.left, ans);
        ans.add(root.val);
        if (root.right != null) inorderTraversal(root.right, ans);
    }
}