class Solution {
    public boolean isPalindrome(String t) {
        int left = 0;
        int right = t.length() - 1;

        while (left < right) {
            char leftChar = Character.toLowerCase(t.charAt(left));
            char rightChar = Character.toLowerCase(t.charAt(right));

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            if (leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}