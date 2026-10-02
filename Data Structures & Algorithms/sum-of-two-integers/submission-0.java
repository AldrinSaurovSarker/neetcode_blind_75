class Solution {
    public int getSum(int a, int b) {
        int carry = 0;
        int num = 0;

        for (int i = 0; i < 32; i++) {
            int bitA = (a >>> i) & 1;
            int bitB = (b >>> i) & 1;

            int currentSum = sum(bitA, bitB, carry);
            int nextCarry = carryOut(bitA, bitB, carry);

            num |= (currentSum << i);

            carry = nextCarry;
        }
        return num;
    }

    public int carryOut(int a, int b, int c) {
        return (a & b) | (b & c) | (c & a);
    }

    public int sum(int a, int b, int c) {
        return a ^ b ^ c;
    }
}
