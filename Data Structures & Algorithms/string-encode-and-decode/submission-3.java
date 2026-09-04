class Solution {

    public String encode(List<String> strs) {
        // the length of the string + # + string
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str.length() + "#" + str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        char[] carr = str.toCharArray();
        int len = 0;
        List<String> ans = new ArrayList<>();

        while (i < str.length()) {
            if (carr[i] == '#') {
                ans.add(str.substring(i + 1, i + 1 + len));
                i = i + 1 + len;
                len = 0;
            } else {
                len = len * 10 + (carr[i] - '0');
                i++;
            }
        }
        return ans;
    }
}
