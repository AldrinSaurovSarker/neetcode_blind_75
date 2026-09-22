class Solution {
    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        helper(nums, 0, current);
        return ans;
    }

    public void helper(int[] nums, int index, List<Integer> current) {
        ans.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            helper(nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
