class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int lowest = nums[0];
        int highest = nums[nums.length - 1];

        if(highest % lowest == 0){
            return lowest;
        }


        return helper(lowest , highest);


    }

    public int helper(int x , int y){
        if(y % x == 0){
            return x;
        }
        int rem = y % x;
        int res = helper(y % x , x);
        return res;
    
    }
}