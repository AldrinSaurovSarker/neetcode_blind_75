class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        for (int i = 1; i <= n; i++) {
            queue.offer(new int[]{dist[i], i});
        }

        while (visited.size() < n) {
            int[] node = queue.poll();
            int min = node[0];
            int idx = node[1];

            if (visited.contains(idx)) {
                continue;
            }

            if (min == Integer.MAX_VALUE) {
                return -1;
            }

            for (int[] time : times) {
                int u = time[0];
                int v = time[1];

                if (u == idx) {
                    int newDist = dist[u] + time[2];
                    
                    if (dist[u] + time[2] < dist[v]) {
                        dist[v] = newDist;
                        queue.offer(new int[]{dist[v], v});
                    }
                }
            }
            visited.add(idx);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
