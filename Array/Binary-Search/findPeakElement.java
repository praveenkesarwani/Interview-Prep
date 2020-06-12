class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid1 = 0;
        int mid2 = 0;
        while(left < right){
            mid1 = left + (right - left ) / 2;
            mid2 = mid1 + 1;
            if(nums[mid1] < nums[mid2]){
                left = mid2;
            }
            else{
                right = mid1;
            }
        }
        return left;
    }
}
/*
Time Complexity: O(logn)
Space Complexity: O(1)
*/