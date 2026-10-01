class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquareDigits(n);

        while (slow != fast) {
            slow = sumOfSquareDigits(slow);
            fast = sumOfSquareDigits(sumOfSquareDigits(fast));
        }
        return slow == 1;
    }

    public int sumOfSquareDigits(int n) {
        int sum = 0;

        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
