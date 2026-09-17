class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int right = 0;
        int ans = 0;

        while (right < s.length()) {
            freq[s.charAt(right) - 'A']++;

            int max = 0; 
            for (int f : freq) {
                max = Math.max(f, max);
            }

            if (max < right - left + 1 - k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
