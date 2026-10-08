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
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return builder(0, preorder.length - 1, preorder, map);
    }

    public TreeNode builder(int start, int end, int[] preorder, Map<Integer, Integer> map) {
        if (start > end || index >= preorder.length) {
            return null;
        }

        int value = preorder[index++];
        int mid = map.get(value);

        TreeNode node = new TreeNode(value);
        node.left = builder(start, mid - 1, preorder, map);
        node.right = builder(mid + 1, end, preorder, map);
        return node;
    }
}
