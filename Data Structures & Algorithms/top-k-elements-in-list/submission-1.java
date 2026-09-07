class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, 1 + freq.getOrDefault(num, 0));
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] ans = new int[k];
        int i = 0;

        while (!queue.isEmpty()) {
            ans[i] = queue.poll()[0];
            i++;
        }
        return ans;
    }
}
