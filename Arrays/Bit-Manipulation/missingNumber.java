//Given a list of n-1 integers where integers are in the range 1 to n, 
//with no duplicates, find the missing integer.
//Hint: Use XOR to achieve this
class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }
}