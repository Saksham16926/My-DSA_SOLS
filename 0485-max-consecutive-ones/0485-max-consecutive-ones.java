class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0;
        int omax = 0;

        int i = 0;
        while(i < nums.length){
            if(nums[i] == 0){
                curr = 0;
                i++;
            }else{
                curr++;
                 if(curr > omax){
                    omax = curr;
                    
                }
                i++;
            }
        }
        if(curr > omax){
            omax = curr;
        }
        return omax;
    }
}