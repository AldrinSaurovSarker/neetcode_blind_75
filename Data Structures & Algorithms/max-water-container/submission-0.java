class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int ans = 0;

        while (left < right) {
            int water = Math.min(heights[left], heights[right]) * (right - left);
            ans = Math.max(water, ans);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
