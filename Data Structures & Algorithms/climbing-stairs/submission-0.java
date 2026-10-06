class Solution {
    // recursive
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        return climbStairs(n, dp);
    }

    public int climbStairs(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
        return dp[n];
    }
}
