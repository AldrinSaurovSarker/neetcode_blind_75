class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int a = nums[0];
        int b = nums[1];
        int c = nums[0] + nums[2];

        for (int i = 3; i < n; i++) {
            int current = nums[i] + Math.max(a, b);

            a = b;
            b = c;
            c = current;
        }

        return Math.max(b, c);
    }
}
