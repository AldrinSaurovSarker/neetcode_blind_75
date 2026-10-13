class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] connections = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            connections[prerequisite[0]]++;
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (connections[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            index++;

            for (int neighbor : graph.get(node)) {
                connections[neighbor]--;

                if (connections[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return index == numCourses;
    }
}
