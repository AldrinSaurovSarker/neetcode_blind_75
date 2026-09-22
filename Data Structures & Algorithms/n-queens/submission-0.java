class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(0, n, board, ans);
        return ans;
    }

    public void helper(int i, int n, char[][] board, List<List<String>> ans) {
        if (i == n) {
            List<String> result = new ArrayList<>();
            for (char[] row : board) {
                result.add(new String(row));
            }
            ans.add(result);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValidMove(i, j, n, board)) {
                board[i][j] = 'Q';
                helper(i + 1, n, board, ans);
                board[i][j] = '.';
            }
        }
    }

    public boolean isValidMove(int i, int j, int n, char[][] board) {
        for (int x = 0; x < n; x++) {
            if (board[x][j] == 'Q') {
                return false;
            }

            int y1 = x + j - i;
            if (y1 >= 0 && y1 < n && board[x][y1] == 'Q') {
                return false;
            }

            int y2 = i + j - x;
            if (y2 >= 0 && y2 < n && board[x][y2] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
