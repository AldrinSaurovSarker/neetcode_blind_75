class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(i, j, 0, board, new boolean[m][n], word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(int i, int j, int index, char[][] board, boolean[][] used, String word) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (used[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        used[i][j] = true;
        boolean found = helper(i - 1, j, index + 1, board, used, word) ||
                        helper(i, j - 1, index + 1, board, used, word) ||
                        helper(i + 1, j, index + 1, board, used, word) ||
                        helper(i, j + 1, index + 1, board, used, word);
        used[i][j] = false;
        return found;
    }
}
