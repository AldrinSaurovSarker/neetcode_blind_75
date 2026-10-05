class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board);
            }

            if (board[n - 1][j] == 'O') {
                dfs(n - 1, j, board);
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }

            if (board[i][m - 1] == 'O') {
                dfs(i, m - 1, board);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] == '#' ? 'O' : 'X';
            }
        }
    }

    public void dfs(int x, int y, char[][] board) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') {
            return;
        }

        board[x][y] = '#';
        dfs(x - 1, y, board);
        dfs(x + 1, y, board);
        dfs(x, y - 1, board);
        dfs(x, y + 1, board);
    }
}
