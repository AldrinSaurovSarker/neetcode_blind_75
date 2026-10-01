class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < (Math.min(n, m) + 1) / 2; i++) {
            for (int j = i; j < m - i; j++) {
                ans.add(matrix[i][j]);
            }

            for (int j = i + 1; j < n - i - 1; j++) {
                ans.add(matrix[j][m - i - 1]);
            }

            if (i != n - 1 - i) {
                for (int j = m - 1 - i; j >= i; j--) {
                    ans.add(matrix[n - 1 - i][j]);
                }
            }

            if (m % 2 == 0 || i != (m - 1)/2) {
                for (int j = n - i - 2; j > i; j--) {
                    ans.add(matrix[j][i]);
                }
            }
        }

        return ans;
    }
}
