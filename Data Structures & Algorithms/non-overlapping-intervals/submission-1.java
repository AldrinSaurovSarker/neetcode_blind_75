class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return 0;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int count = 0;

        for (int[] interval : intervals) {
            queue.offer(interval);
        }

        while (queue.size() > 1) {
            int[] first = queue.poll();
            int[] second = queue.poll();

            if (first[1] > second[0]) {
                queue.offer(first[1] > second[1] ? second : first);
                count++;
            } else {
                queue.offer(second);
            }
        }
        return count;
    }
}
