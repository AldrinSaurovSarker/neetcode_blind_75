class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        queue.offer(new int[]{0, k});

        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int min = node[0];
            int idx = node[1];

            if (visited.contains(idx)) {
                continue;
            }

            for (int[] time : graph.get(idx)) {
                int v = time[0];
                int t = time[1];

                int newDist = dist[idx] + t;
                
                if (dist[idx] + t < dist[v]) {
                    dist[v] = newDist;
                    queue.offer(new int[]{dist[v], v});
                }
            }
            visited.add(idx);
        }

        if (visited.size() < n) {
            return -1;
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
