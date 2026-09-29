class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = 0;
        int ans = 0;

        for (int num : nums) {
            if (num == 1) {
                length++;
            } else {
                ans = Math.max(length, ans);
                length = 0;
            }
        }
        return Math.max(length, ans);
    }
}