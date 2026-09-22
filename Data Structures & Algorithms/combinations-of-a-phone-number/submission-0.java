class Solution {
    String[] lookup = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;
        helper(digits, 0, new StringBuilder());
        return ans;
    }

    public void helper(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        for (char c : lookup[digits.charAt(index) - '0'].toCharArray()) {
            sb.append(c);
            helper(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
