class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0, new StringBuilder());
        return ans;
    }

    public void helper(int n, int ob, int cb, StringBuilder sb) {
        if (sb.length() == n * 2) {
            if (ob == cb) {
                ans.add(sb.toString());
            }
            return;
        }

        if (ob < n) {
            sb.append('(');
            helper(n, ob + 1, cb, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (ob > cb) {
            sb.append(')');
            helper(n, ob, cb + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
