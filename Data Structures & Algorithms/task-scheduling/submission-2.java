class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        Deque<int[]> queue = new ArrayDeque<>();

        for (int f : freq) {
            if (f > 0) {
                heap.offer(f);
            }
        }

        int time = 0;
        while (!heap.isEmpty() || !queue.isEmpty()) {
            time++;

            if (heap.isEmpty()) {
                time = queue.peek()[0];
            }

            if (!queue.isEmpty() && queue.peek()[0] == time) {
                int num = queue.poll()[1];
                heap.offer(num);
            }

            if (!heap.isEmpty()) {
                int num = heap.poll();
                if (num > 1) {
                    queue.offer(new int[]{time + n + 1, num - 1});
                }
            }
        }
        return time;
    }
}

