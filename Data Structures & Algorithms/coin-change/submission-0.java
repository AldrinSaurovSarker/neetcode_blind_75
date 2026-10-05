class Solution {
    // recursive
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        dp[0] = 0;

        return coinChange(coins, amount, dp);
    }

    public int coinChange(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }

        if (dp[amount] != -2) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coinChange(coins, amount - coin, dp);
            if (result != -1) {
                min = Math.min(min, 1 + result);
            }
        }

        dp[amount] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[amount];
    }
}
