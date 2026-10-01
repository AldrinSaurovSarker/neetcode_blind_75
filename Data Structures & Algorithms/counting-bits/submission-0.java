class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        bits[0] = 0;
        int exp = 1;

        for (int i = 1; i <= n; i++) {
            if (i == exp) {
                exp *= 2;
            }
            bits[i] = 1 + bits[i - exp / 2];
        }
        return bits;
    }
}
