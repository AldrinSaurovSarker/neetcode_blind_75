class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return Math.max(
            helper(0, nums, dp),
            helper(1, nums, dp)
        );
    }

    public int helper(int index, int[] nums, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        dp[index] = nums[index] + Math.max(helper(index + 2, nums, dp), helper(index + 3, nums, dp));
        return dp[index];
    }
}
