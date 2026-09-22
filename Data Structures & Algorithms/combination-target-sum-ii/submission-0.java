class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, -1, 0, current);
        return ans;
    }

    public void helper(int[] candidates, int target, int index, int sum, List<Integer> current) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = index + 1; i < candidates.length; i++) {
            if (i > index + 1 && candidates[i] == candidates[i - 1]) {
                continue;
            }

            current.add(candidates[i]);
            helper(candidates, target, i, sum + candidates[i], current);
            current.remove(current.size() - 1);
        }
    }
}
