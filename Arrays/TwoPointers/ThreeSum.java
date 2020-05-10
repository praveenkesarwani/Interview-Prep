//Given an array,ind all unique triplets (3 numbers) that add up to 0. 
//There should be no duplicates.
//Input: [-3, 0, 1, 2, -1, 1, -2]
//Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
class ThreeSum {

    void twoSum (Integer nums[],int target,int first_ptr,List<List<Integer>>ans){
        int second_ptr = nums.length - 1;
        while(first_ptr < second_ptr){
            int current_sum = nums[first_ptr] + nums[second_ptr];
            if(current_sum == target){
                ans.add(Arrays.asList(-target,nums[first_ptr],nums[second_ptr]));
                first_ptr++;
                second_ptr--;
                while(nums[first_ptr] == nums[first_ptr - 1] && first_ptr < second_ptr){
                    first_ptr++;
                }
                while(nums[second_ptr] == nums[second_ptr + 1] && first_ptr < second_ptr){
                    second_ptr--;
                }
            }
            else if(current_sum < target){
                first_ptr++;
            }
            else{
                second_ptr--;
            }
        }
    }

    public List<List<Integer>> threeSum(Integer[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (Integer i = 0; i < nums.length-2; i++)
        {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int ptr = i + 1;
            twoSum(nums,target,ptr,ans); // Reduced the problem in twoSum problem
        }
        return ans;
    }
}