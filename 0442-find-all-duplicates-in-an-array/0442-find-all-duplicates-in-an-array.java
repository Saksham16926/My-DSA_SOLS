class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        if(nums.length == 0 || nums.length == 1){
            return res;
        }  
        for(int i = 0 ; i < nums.length ; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                res.add(nums[i]);
            }
        }
        return res;
    }
}