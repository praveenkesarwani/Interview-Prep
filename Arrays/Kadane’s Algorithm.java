//53. Maximum Subarray
//Kadane’s Algorithm:
class Solution {
    public int maxSubArray(int[] nums) {
        int size = nums.length; 
        int max_so_far = Integer.MIN_VALUE;
        int sum = 0; 
  
        for (int i = 0; i < size; i++) 
        { 
            sum += nums[i];
            max_so_far = Math.max(max_so_far,sum);
            sum = Math.max(sum,0);
        } 
        return max_so_far; 
    }
}
/*
Time Complexity: O(N), N is the size of array
Space Complexity: O(1),constant space is used
*/