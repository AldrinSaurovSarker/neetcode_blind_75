class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int ithBit = (n >> i) & 1;
            ans |= (ithBit << 32 - i - 1);
        }
        return ans;
    }
}
