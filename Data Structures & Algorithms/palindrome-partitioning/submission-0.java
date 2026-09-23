class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(0, s, new StringBuilder(), new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int index, String s, StringBuilder sb, List<String> current, List<List<String>> ans) {
        if (index == s.length()) {
            if (sb.isEmpty()) {
                ans.add(new ArrayList<>(current));
            }
            return;
        }

        sb.append(s.charAt(index));

        if (isPalindrome(sb.toString())) {
            current.add(sb.toString());
            StringBuilder temp = sb;
            sb = new StringBuilder();
            helper(index + 1, s, sb, current, ans);
            current.remove(current.size() - 1);
            sb = temp;
        }
        helper(index + 1, s, sb, current, ans);
    }

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
