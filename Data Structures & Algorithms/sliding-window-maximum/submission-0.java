class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int[] ans = new int[nums.length - k + 1];

        for (int right = 0; right < nums.length; right++) {
            queue.offer(new int[]{nums[right], right});

            if (queue.size() >= k) {
                int left = right + 1 - k;
                while (queue.peek()[1] < left) {
                    queue.poll();
                }
                ans[left] = queue.peek()[0];
            }
        }
        return ans;
    }
}
