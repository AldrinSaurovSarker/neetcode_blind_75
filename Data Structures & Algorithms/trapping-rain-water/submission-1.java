// Approach: Prefix & Suffix
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    public int trap(int[] height) {
        int[] leftBoundary = new int[height.length];
        int[] rightBoundary = new int[height.length];

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            leftBoundary[i] = max;
            max = Math.max(max, height[i]);
        }

        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            rightBoundary[i] = max;
            max = Math.max(max, height[i]);
        }

        int totalWater = 0;
        for (int i = 0; i < height.length; i++) {
            int water = Math.max(Math.min(leftBoundary[i], rightBoundary[i]) - height[i], 0);
            totalWater += water;
        }
        return totalWater;
    }
}
