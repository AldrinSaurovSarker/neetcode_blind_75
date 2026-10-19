class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int target = sum / 2;

        int[][] dp = new int[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        if (sum % 2 == 1) return false;

        return helper(0, nums, 0, target, dp);
    }

    public boolean helper(int index, int[] nums, int sum, int target, int[][] dp) {
        if (sum == target) return true;

        if (index == nums.length || sum > target) {
            return false;
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum] == 1;
        }

        boolean result = helper(index + 1, nums, sum, target, dp) || helper(index + 1, nums, sum + nums[index], target, dp);
        dp[index][sum] = result ? 1 : 0;
        return dp[index][sum] == 1;
    }
}
