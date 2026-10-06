class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        return Math.max(
            rob(0, n - 1, nums), rob(1, n, nums)
        );
    }

    public int rob(int start, int end, int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return Math.max(
            helper(start, nums, dp, end),
            helper(start + 1, nums, dp, end)
        );
    }

    public int helper(int index, int[] nums, int[] dp, int end) {
        if (index >= end) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        dp[index] = nums[index] + Math.max(
            helper(index + 2, nums, dp, end),
            helper(index + 3, nums, dp, end)
        );
        return dp[index];
    }
}
