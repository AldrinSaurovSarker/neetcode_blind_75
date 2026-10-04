class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                visited[i][j] = true;
            }
        }

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];

                grid[x][y] = time;

                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
                        continue;
                    }

                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
            
            if (!queue.isEmpty()) {
                time++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    return -1;
                }
            }
        }

        return time;
    }
}
