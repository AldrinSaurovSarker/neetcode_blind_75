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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        preorderTraversal(root, ans);
        return ans;
    }

    public void preorderTraversal(TreeNode root, List<Integer> ans) {
        ans.add(root.val);
        if (root.left != null) preorderTraversal(root.left, ans);
        if (root.right != null) preorderTraversal(root.right, ans);
    }
}