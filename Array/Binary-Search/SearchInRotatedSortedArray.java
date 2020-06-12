class SearchInRotatedSortedArray {
    // complete the below function implementation
    public int search(int[] nums, int target) {
        int first = 0;
        int last = nums.length - 1;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[first] <= nums[mid]) { //Left Half sorted
                if (target >= nums[first] && target < nums[mid]) {
                    last = mid - 1;         //Search left Half
                } else {
                    first = mid + 1;        //Search right Half
                }
            } else {                        //Right Half sorted
                if (target > nums[mid] && target <= nums[last]) {
                    first = mid + 1;        //Search right Half
                } else {
                    last = mid - 1;         //Search left Half
                }
            }
        }
        return -1;
    }