class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int left = 0;
        int right = 0;

        while (right < s2.length()) {
            freq2[s2.charAt(right) - 'a']++;

            if (right - left + 1 < s1.length()) {
                right++;
                continue;
            }

            boolean flag = true;

            for (int i = 0; i < 26; i++) {
                if (freq1[i] != freq2[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) return true;
            
            freq2[s2.charAt(left) - 'a']--;
            left++;
            right++;
        }
        return false;
    }
}
