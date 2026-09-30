class Solution {
    public double myPow(double x, int N) {
        double ans = 1;
        long n = N;

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * x;
            }
            n = n >> 1;
            x *= x;
        }
        return ans;
    }
}
