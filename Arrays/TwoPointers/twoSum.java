//In an array of integers, find 2 numbers that add up to a given value
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                output[0] = i;
                output[1] = map.get(target - nums[i]);
                return output;
            }
        }
        return output;
    }
}