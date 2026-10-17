class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int a = min * num;
            int b = max * num;

            min = Math.min(num, Math.min(a, b));
            max = Math.max(num, Math.max(a, b));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
