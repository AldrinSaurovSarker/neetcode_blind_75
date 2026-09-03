class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList();
        Map<String, List<String>> map = new HashMap();

        for (String str : strs) {
            int[] freq = new int[26];
            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for (int count : freq) {
                keyBuilder.append(count).append('#');
            }
            String key = keyBuilder.toString();

            List<String> entry = map.getOrDefault(key, new ArrayList());
            entry.add(str);
            map.put(key, entry);
        }

        for (List<String> value : map.values()) {
            ans.add(value);
        }
        return ans;
    }
}
