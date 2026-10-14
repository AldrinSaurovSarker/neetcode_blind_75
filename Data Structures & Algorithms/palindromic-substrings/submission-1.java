class Solution {
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expand(i, i, s) + expand(i - 1, i, s);
        }

        return count;
    }

    public int expand(int x, int y, String s) {
        int count = 0;

        while (x >= 0 && y < s.length() && s.charAt(x) == s.charAt(y)) {
            count++;
            x--;
            y++;
        }
        return count;
    }
}
