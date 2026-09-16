class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> queue = new ArrayDeque<>();
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            while (!queue.isEmpty() && queue.peek()[1] > heights[i]) {
                int[] popped = queue.pop();
                int index = popped[0];
                int value = popped[1];

                int area = value * (i - index);
                max = Math.max(area, max);
                start = index;
            }
            queue.push(new int[]{start, heights[i]});
        }

        while (!queue.isEmpty()) {
            int[] popped = queue.pop();
            int index = popped[0];
            int value = popped[1];

            int area = value * (heights.length - index);
            max = Math.max(area, max);
        }

        return max;
    }
}
