class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for (int val : nums) {
            set.add(val);
        }

        for (int val : set) {
            if (!set.contains(val - 1)) {
                int seq = val;

                while (set.contains(seq)) {
                    seq++;
                }

                ans = Math.max(ans, seq - val);
            }
        }

        return ans;
    }
}
