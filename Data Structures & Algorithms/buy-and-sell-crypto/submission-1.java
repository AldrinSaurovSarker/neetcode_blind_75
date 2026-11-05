class Solution {
    public int maxProfit(int[] prices) {
        int j = 0;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(prices[i] - prices[j], maxProfit);
            
            if (prices[i] < prices[j]) {
                j = i;
            }
        }
        return maxProfit;
    }
}
