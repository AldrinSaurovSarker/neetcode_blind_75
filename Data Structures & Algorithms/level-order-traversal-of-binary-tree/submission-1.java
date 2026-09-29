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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int next = 0;
        int current = 1;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                next++;
            }

            if (node.right != null) {
                queue.add(node.right);
                next++;
            }

            current--;

            if (current == 0) {
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
                current = next;
                next = 0;
            }
        }
        return res;
    }
}
