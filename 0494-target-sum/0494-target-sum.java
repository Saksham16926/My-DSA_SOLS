class Solution { 
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }

    public int helper(int[] nums, int target, int index, int sum){
        if(index == nums.length){
            if(sum == target){
                count ++;
                return count;
            }else{
                return count;
            }
        }

        int left = helper(nums, target, index + 1, sum + nums[index]);
        int right = helper(nums, target, index + 1, sum - nums[index]);

        return count;
    }
}