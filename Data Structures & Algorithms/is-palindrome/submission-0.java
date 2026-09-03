class Solution {
    public boolean isPalindrome(String t) {
        StringBuilder s = new StringBuilder();
        for (char c: t.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                c += 32;
            }

            if ('A' <= c && c <= 'Z' || 'a' <= c && c <= 'z' || '0' <= c && c <= '9') {
                s.append(c);
            }
        }

        for (int i=0, j=s.length()-1; i<j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}