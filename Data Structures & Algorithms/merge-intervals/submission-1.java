class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();

        for (int[] curr : intervals) {
            queue.offer(curr);
        } 

        while (queue.size() > 1) {
            int[] prev = queue.poll();
            int[] curr = queue.poll();

            if (prev[1] < curr[0]) {
                queue.offer(curr);
                list.add(prev);
            } else {
                int[] merged = new int[]{prev[0], Math.max(prev[1], curr[1])};
                queue.offer(merged);
            }
        }

        list.add(queue.poll());
        int[][] ans = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
