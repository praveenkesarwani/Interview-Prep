//Move all 0s in an integer array to one end maintaining order of other elements
class Solution {
    public void moveZeroes(int[] nums) {
        int first_ptr = 0;
        int second_ptr = 0;
        int n = nums.length;
        while (first_ptr <= second_ptr && second_ptr < n) {
            if (nums[first_ptr] != 0) {
                first_ptr++;
                second_ptr++;
            } else if (nums[second_ptr] != 0) {
                nums[first_ptr] = nums[first_ptr] ^ nums[second_ptr];
                nums[second_ptr] = nums[first_ptr] ^ nums[second_ptr];
                nums[first_ptr] = nums[first_ptr] ^ nums[second_ptr];
                first_ptr++;
                second_ptr++;
            } else {
                second_ptr++;
            }
        }
    }
}