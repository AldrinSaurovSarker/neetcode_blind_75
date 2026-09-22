class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n + 1];
        boolean[] diag2 = new boolean[2 * n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(0, n, board, col, diag1, diag2, ans);
        return ans;
    }

    public void helper(int i, int n, char[][] board, boolean[] col, boolean[] diag1, boolean[] diag2, List<List<String>> ans) {
        if (i == n) {
            List<String> result = new ArrayList<>();
            for (char[] row : board) {
                result.add(new String(row));
            }
            ans.add(result);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!col[j] && !diag1[i + j] && !diag2[i - j + n]) {
                board[i][j] = 'Q';
                col[j] = true;
                diag1[i + j] = true;
                diag2[i - j + n] = true;

                helper(i + 1, n, board, col, diag1, diag2, ans);
                
                board[i][j] = '.';
                col[j] = false;
                diag1[i + j] = false;
                diag2[i - j + n] = false;
            }
        }
    }
}
