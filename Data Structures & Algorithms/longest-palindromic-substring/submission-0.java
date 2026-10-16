class Solution {
    public String longestPalindrome(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            String s1 = expand(i, i, ans.length(), s);
            if (s1.length() > ans.length()) ans = s1;
            String s2 = expand(i - 1, i, ans.length(), s);
            if (s2.length() > ans.length()) ans = s2;
        }
        return ans;
    }

    public String expand(int left, int right, int max, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1 > max ? s.substring(left + 1, right) : "";
    }
}
