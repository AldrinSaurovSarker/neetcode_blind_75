class Solution {
    public String longestPalindrome(String s) {
        int maxIdx = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            int l1 = expand(i, i, s);
            int l2 = expand(i - 1, i, s);
            
            int len1 = 2 * (i - l1) + 1;
            int len2 = 2 * (i - l2);

            if (len1 > maxLen) {
                maxLen = len1;
                maxIdx = l1;
            }

            if (len2 > maxLen) {
                maxLen = len2;
                maxIdx = l2;
            }
        }
        return s.substring(maxIdx, maxIdx + maxLen);
    }

    public int expand(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return left + 1;
    }
}
