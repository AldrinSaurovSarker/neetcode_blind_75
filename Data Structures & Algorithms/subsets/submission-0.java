class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(nums, 0, current, subsets);
        return subsets;
    }

    public void helper(int[] nums, int index, List<Integer> current, List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        helper(nums, index + 1, current, subsets);
        current.add(nums[index]);
        helper(nums, index + 1, current, subsets);
        current.remove(current.size() - 1);
    }
}
