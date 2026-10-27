class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = j = s.length() - 1;

        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);

            if (!Character.isLetterOrDigit(c1)) {
                i++;
                continue;
            }
            
            if (!Character.isLetterOrDigit(c2)) {
                j--;
                continue;
            }

            if (Character.toUpperCase(c1) != Character.toUpperCase(c2)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
