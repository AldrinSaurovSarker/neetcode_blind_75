class Solution {
    public int reverse(int x) {
        int ans = 0;

        int min = Integer.MIN_VALUE; //  2,147,483,647
        int max = Integer.MAX_VALUE; // -2,147,483,648

        while (x != 0) {
            int digit = x % 10;

            if (ans > max / 10 || (ans == max / 10 && digit > 7)) {
                return 0;
            }

            if (ans < min / 10 || (ans == min / 10 && digit < -8)) {
                return 0;
            }

            ans = ans * 10 + digit;
            x /= 10;
        }
        return ans;
    }
}
