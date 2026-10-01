class Solution {
    public boolean isHappy(int n) {
        for (int i = 0; i < 20; i++) {
            n = sumOfSquareDigits(n);
        }
        
        return n == 1;
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
