class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] connections = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] prerequisite : prerequisites) {
            connections[prerequisite[0]]++;
            map.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (connections[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited.add(node);
            index++;

            for (int neighbor : map.getOrDefault(node, new ArrayList<>())) {
                if (visited.contains(neighbor)) continue;
                connections[neighbor]--;

                if (connections[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return index == numCourses;
    }
}
