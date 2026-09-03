class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int current = 0;
        int last = 0;

        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                max = Math.max(max, current);
                last = Math.max(last, map.get(s.charAt(i)));
                current = i - last;
            } else {
                current++;
            }
            map.put(s.charAt(i), i);
        }

        return Math.max(max, current);
    }
}
