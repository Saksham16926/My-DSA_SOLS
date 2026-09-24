class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            if(helper(nums[i]) == i){
                return i;
            }
        }
        return -1;
   }

   public int helper(int a){
    int sum = 0;
    while(a > 0){
        sum += a%10;
        a = a / 10;
    }

    return sum;
   }
}