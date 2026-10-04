class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int sz = 0; sz < size; sz++) {
                int[] treasure = queue.poll();
                int i = treasure[0];
                int j = treasure[1];
                grid[i][j] = distance;

                for (int[] direction : directions) {
                    int nr = i + direction[0];
                    int nc = j + direction[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc] || grid[nr][nc] == -1) {
                        continue;
                    }
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }

            distance++;
        }
    }
}
