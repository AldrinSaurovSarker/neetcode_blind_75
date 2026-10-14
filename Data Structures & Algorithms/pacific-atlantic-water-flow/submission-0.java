class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int grid[][] = new int[n][m];

        waterFlow(heights, grid, 0, 0, 1);
        waterFlow(heights, grid, n - 1, m - 1, 2);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 3) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        System.out.println(Arrays.deepToString(grid));
        return res;
    }

    public void waterFlow(int[][] heights, int[][] grid, int x, int y, int pass) {
        Deque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            if ((grid[i][y] & pass) == 0) {
                grid[i][y] |= pass;
                queue.offer(new int[]{i, y});
            }
        }

        for (int j = 0; j < heights[0].length; j++) {
            if ((grid[x][j] & pass) == 0) {
                grid[x][j] |= pass;
                queue.offer(new int[]{x, j});
            }
        }

        bfs(heights, grid, queue, pass);
    }

    public void bfs(int[][] heights, int[][] grid, Deque<int[]> queue, int pass) {
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] block = queue.poll();
            int x = block[0];
            int y = block[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx < 0 || ny < 0 || nx >= heights.length || ny >= heights[0].length || (grid[nx][ny] & pass) != 0) {
                    continue;
                }

                if (heights[x][y] <= heights[nx][ny]) {
                    grid[nx][ny] |= pass;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
