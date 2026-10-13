class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Deque<Integer> queue = new ArrayDeque<>();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        int[] path = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int required = prerequisite[1];

            indegree[course]++;
            graph.get(required).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            path[index++] = node;

            for (int neighbor : graph.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        if (index != numCourses) {
            return new int[]{};
        }
        return path;
    }
}
