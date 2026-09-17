class Solution {
    public String minWindow(String s, String t) {
        int[] freq1 = new int[128];
        int[] freq2 = new int[128];
        int shortLength = Integer.MAX_VALUE;
        String ans = "";

        for (char c : t.toCharArray()) {
            freq1[c]++;
        }

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (freq1[s.charAt(left)] == 0 || right - left + 1 == shortLength) {
                freq2[s.charAt(left)] = Math.max(freq2[s.charAt(left)] - 1, 0);
                left++;
                if (left > right) right = left;
                continue;
            }

            freq2[s.charAt(right)]++;

            boolean flag = true;
            for (int i = 0; i < 128; i++) {
                if (freq2[i] < freq1[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag && shortLength > right - left + 1) {
                while (freq2[s.charAt(left)] > freq1[s.charAt(left)]) {
                    freq2[s.charAt(left)]--;
                    left++;
                }

                shortLength = right - left + 1;
                ans = s.substring(left, right + 1);
                freq2[s.charAt(left)]--;
                left++;
            }

            right++;
        }
        return ans;
    }
}
