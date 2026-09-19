class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            digits[i] = (digit + carry) % 10;
            carry = (digit + carry) / 10;

            if (carry == 0) break;
        }

        if (carry == 1) {
            int[] ans = new int[digits.length + 1];

            ans[0] = 1;
            for (int i = 1; i <= digits.length; i++) {
                ans[i] = digits[i - 1];
            }
            return ans;
        } else {
            return digits;
        }
    }
}
