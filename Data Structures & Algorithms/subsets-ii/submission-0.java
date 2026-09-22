class Solution {
    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> current = new ArrayList<>();
        helper(nums, 0, current);
        return ans;
    }

    public void helper(int[] nums, int index, List<Integer> current) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        helper(nums, index + 1, current);
        current.remove(current.size() - 1);

        while (index < nums.length - 1 && nums[index + 1] == nums[index]) {
            index++;
        }

        helper(nums, index + 1, current);
    }
}
