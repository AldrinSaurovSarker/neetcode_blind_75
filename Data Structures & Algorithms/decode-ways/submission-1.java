class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return helper(0, s, memo);
    }

    public int helper(int index, String s, int[] memo) {
        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int way1 = helper(index + 1, s, memo);
        int way2 = 0;

        if (index + 1 < s.length()) {
            int value = Integer.valueOf(s.substring(index, index + 2));
            if (10 <= value && value <= 26) {
                way2 = helper(index + 2, s, memo);
            }
        }

        return memo[index] = way1 + way2;
    }
}
