class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int prod1 = 1;
        int prod2 = 0;

        for (int num : nums) {
            if (num == 0) {
                ans = Math.max(ans, 0);
                prod1 = 1;
                prod2 = 0;
                continue;
            }

            if (prod2 != 0) prod2 *= num;

            prod1 *= num;
            ans = Math.max(ans, prod1);

            if (prod2 != 0) {
                ans = Math.max(ans, prod2);
            } else if (num < 0) {
                prod2 = 1;
            }
        }
        return ans;
    }
}
