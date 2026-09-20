class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        high = low + nums.length - 1;

        while (low <= high) {
            int im_mid = low + (high - low) / 2;
            int mid = convertMid(im_mid, nums.length);

            if (nums[mid] == target) 
                return mid;
            else if (nums[mid] < target)
                low = im_mid + 1;
            else
                high = im_mid - 1;
        }
        return -1;
    }

    public int convertMid(int index, int length) {
        if (index < length) return index;
        return index - length;
    }
}



