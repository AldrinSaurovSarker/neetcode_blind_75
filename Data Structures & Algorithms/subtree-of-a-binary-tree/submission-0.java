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
    public void getCandidateNodes(TreeNode root, TreeNode subRoot, List<TreeNode> arr) {
        if (root == null) {
            return;
        }

        if (root.val == subRoot.val) {
            arr.add(root);
        }

        getCandidateNodes(root.left, subRoot, arr);
        getCandidateNodes(root.right, subRoot, arr);
    }

    public boolean compareRoots(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null || root.val != subRoot.val) return false;
        return compareRoots(root.left, subRoot.left) && compareRoots(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<TreeNode> arr = new ArrayList<>();
        getCandidateNodes(root, subRoot, arr);

        for (TreeNode node : arr) {
            if (compareRoots(node, subRoot)) return true;
        }
        return false;
    }
}
