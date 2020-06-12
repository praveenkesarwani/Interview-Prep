//Input: [2, 4, 4, 4, 6, 8, 8]
//Output: 4      //(output array[2,4,6,8])
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int unique_elements_ptr = 1;
        for (int ptr = 1; ptr < nums.length; ptr++) {
            if (nums[unique_elements_ptr - 1] != nums[ptr]) {
                nums[unique_elements_ptr] = nums[ptr];
                unique_elements_ptr++;
            }
        }
        return unique_elements_ptr;
    }
}