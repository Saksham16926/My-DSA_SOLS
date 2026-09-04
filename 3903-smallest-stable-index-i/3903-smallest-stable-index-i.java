class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for(int i = 0 ; i < nums.length; i++){
            if(inScore(nums,i) <= k){
                return i;
            }
        }
        return -1;
    }

    public int inScore(int[] nums, int index){
        int i = 0;
        int j = index;
        int max = nums[0];
         int min = nums[index];

        while(i <= index){
            if(nums[i] > max){
                max = nums[i];
            }
            i++;
        }
        
        while(j <= nums.length - 1){
            if(nums[j] < min){
                min = nums[j];
            }
            j++;
        }

        
        int insc = max - min;
            return insc; 
    }
}