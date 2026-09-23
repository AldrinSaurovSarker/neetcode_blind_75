class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(0, s, new ArrayList<>(), ans);
        return ans;
    }

    public void helper(int index, String s, List<String> current, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int end = index; end < s.length(); end++) {
            if (isPalindrome(s, index, end)) {
                current.add(s.substring(index, end + 1));
                helper(end + 1, s, current, ans);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
