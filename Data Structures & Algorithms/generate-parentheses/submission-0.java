class Solution {
    public void helper(List<String> ans, int n, int ob, int cb, String current) {
        if (ob == n && cb == n) {
            ans.add(current);
        }

        if (ob != n) {
            helper(ans, n, ob + 1, cb, current + "(");
        } 
        
        if (ob > cb) {
            helper(ans, n, ob, cb + 1, current + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, n, 0, 0, "");
        return ans;
    }
}
