// Approach: Two Pointers
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        int totalWater = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                int water = leftMax - height[left];
                totalWater += water;
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                int water = rightMax - height[right];
                totalWater += water;
            }
        }
        return totalWater;
    }
}
