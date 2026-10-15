class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        Arrays.sort(nums);
        int ans = 0;
        int curr = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],1);
        for(int i = 1 ; i < nums.length ; i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            if(nums[i] == nums[i-1] + 1){
                map.put(nums[i], 1);
                curr++;
                if(curr > ans){
                    ans = curr;
                }
            }else{
                curr = 1;
                continue;
            }
        }
        if(ans == 0){
            return 1;
        }
            return ans;
    }
}