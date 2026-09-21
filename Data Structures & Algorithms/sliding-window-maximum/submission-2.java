class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1 - k;

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            while (!deque.isEmpty() && deque.peekFirst() < left) {
                deque.pollFirst();
            }
            deque.offerLast(i);

            if (left >= 0) ans[left] = nums[deque.peekFirst()];
        }

        return ans;
    }
}
