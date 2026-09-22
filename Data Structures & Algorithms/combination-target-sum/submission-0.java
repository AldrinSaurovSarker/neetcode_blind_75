class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        helper(nums, target, 0, 0, current);
        return ans;
    }

    public void helper(int[] nums, int target, int sum, int index, List<Integer> current) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            helper(nums, target, sum + nums[i], i, current);
            current.remove(current.size() - 1);
        }
    }
}
