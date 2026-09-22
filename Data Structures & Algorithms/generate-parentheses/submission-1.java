class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0, "");
        return ans;
    }

    public void helper(int n, int ob, int cb, String s) {
        if (cb > ob) {
            return;
        }

        if (s.length() == n * 2) {
            if (ob == cb) {
                ans.add(s);
            }
            return;
        }

        helper(n, ob + 1, cb, s + '(');
        helper(n, ob, cb + 1, s + ')');
    }
}
