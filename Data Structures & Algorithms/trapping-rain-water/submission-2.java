// Approach: Two Pointers
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                int water = leftMax - height[left];
                totalWater += water;
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                int water = rightMax - height[right];
                totalWater += water;
                right--;
            }
        }
        return totalWater;
    }
}
