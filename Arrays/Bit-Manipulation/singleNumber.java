//Given an array of integers where every element appears twice except for one, 
//find the unique number. Hint: What happens if you XOR all the elements?
class Solution {
    public int singleNumber(int[] nums) {
        int single = nums[0];
        for(int i = 1;i < nums.length;i++){
            single ^= nums[i];
        }
        return single;
    }
}