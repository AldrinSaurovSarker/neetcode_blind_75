class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void dfs(int x, int y, char[][] board) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] == '0' || board[x][y] == 'x') {
            return;
        }

        board[x][y] = 'x';
        dfs(x - 1, y, board);
        dfs(x + 1, y, board);
        dfs(x, y - 1, board);
        dfs(x, y + 1, board);
    }
}
