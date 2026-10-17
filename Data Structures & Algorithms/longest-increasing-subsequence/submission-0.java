class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(0, -1, nums, dp);
    }

    public int helper(int index, int last, int[] nums, int[][] dp) {
        if (index == nums.length) {
            return 0;
        }

        if (dp[index][last + 1] != -1) {
            return dp[index][last + 1];
        }

        int val1 = helper(index + 1, last, nums, dp);
        int val2 = 0;

        if (last == -1 || nums[index] > nums[last]) {
            val2 = 1 + helper(index + 1, index, nums, dp);
        }

        return dp[index][last + 1] = Math.max(val1, val2);
    }
}
