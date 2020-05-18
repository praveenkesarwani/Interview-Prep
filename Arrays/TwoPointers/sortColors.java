//Sort 3 Colors in constant space or Dutch National Flag problem
class Solution {
    public void sortColors(int[] nums) {
        int low_index = 0;
        int mid_index = 0;
        int high_index = nums.length - 1;
        int temp = 0;
        while (mid_index <= high_index) {
            switch (nums[mid_index]) {
                case 0:
                    temp = nums[low_index];
                    nums[low_index] = nums[mid_index];
                    nums[mid_index] = temp;
                    low_index++;
                    mid_index++;
                    break;
                case 1:
                    mid_index++;
                    break;
                case 2:
                    temp = nums[mid_index];
                    nums[mid_index] = nums[high_index];
                    nums[high_index] = temp;
                    high_index--;
                    break;
            }
        }
    }
}
/*
Time complexity: O(n) .
Space complexity: O(1).
*/
