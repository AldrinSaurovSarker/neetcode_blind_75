class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int k = 0;
        int low = 1;
        int high = 1_000_000_000;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int totalTurns = 0;

            for (int pile : piles) {
                totalTurns += Math.ceil((double) pile / mid);
            }

            if (totalTurns <= h) {
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return k;
    }
}
