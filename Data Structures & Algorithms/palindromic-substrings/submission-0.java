class Solution {
    public int countSubstrings(String s) {
        int l = s.length();
        int count = 0;

        for (int i = 0; i < l; i++) {
            int x = i;
            int y = i;
            int z = i - 1;

            while (x >= 0 && y < l && s.charAt(x) == s.charAt(y)) {
                count++;
                x--;
                y++;
            }

            y = i;
            while (z >= 0 && y < l && s.charAt(z) == s.charAt(y)) {
                count++;
                z--;
                y++;
            }
        }

        return count;
    }
}
