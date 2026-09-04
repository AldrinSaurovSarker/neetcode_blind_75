class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j=0; j<9; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        for (int i=0; i<9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j=0; j<9; j++) {
                if (board[j][i] == '.') continue;
                if (set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
        }

        for (int i=0; i<9; i+=3) {
            for (int j=0; j<9; j+=3) {
                Set<Character> set = new HashSet<>();
                for (int x=0; x<3; x++) {
                    for (int y=0; y<3; y++) {
                        if (board[i + x][j + y] == '.') continue;
                        if (set.contains(board[i + x][j + y])) return false;
                        set.add(board[i + x][j + y]);
                    }
                }
            }
        }
        return true;
    }
}
