/*
Given an array as input, find the length of the shortest subarray in it,
sorting which will sort the whole array. This should be achieved with O(1)space.

Input:
7
2 4 3 0 -1 8 15
Output:
5
*/
class ShortestUnsortedContinuousSubarray {
    // complete the below function implementation
    public int findUnsortedSubarrayLength(int[] nums) {
        int start = -1;
        int end = -1;
        int i = 0;
        int j = nums.length - 1;
        int temp = nums[0];
        while(i < nums.length){
            if(nums[i] < temp){
                end = i;
            }
            temp = Math.max(temp,nums[i]);
            i++;
        }
        temp = nums[nums.length - 1];
        while(j >= 0){
            if(nums[j] > temp){
                start = j;
            }
            temp = Math.min(temp,nums[j]);
            j--;
        }
    return start == -1?0:end - start + 1;
    }   
}