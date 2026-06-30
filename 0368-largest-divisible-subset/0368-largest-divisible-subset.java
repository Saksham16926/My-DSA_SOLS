class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 1. We MUST sort so that we only have to check nums[i] % nums[j] == 0
        Arrays.sort(nums);
        
        // dp[i] stores the LENGTH of the subset, not the list itself
        int[] dp = new int[nums.length];
        
        // prev[i] stores the INDEX of the previous number in the subset
        int[] prev = new int[nums.length];
        
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        
        int maxDp = 1;
        int maxIndex = 0;

        for(int i = 1 ; i < nums.length ; i++){
            for(int j = 0 ; j < i ; j++){
                // If they are divisible, check if adding nums[i] makes a longer subset
                if(nums[i] % nums[j] == 0){
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j; // Drop a breadcrumb pointing to j
                    }
                }
            }
            
            // Keep track of where the longest subset ends
            if(dp[i] > maxDp){
                maxDp = dp[i];
                maxIndex = i;
            }
        }
        
        // 2. Build the list EXACTLY ONCE at the very end using the breadcrumbs
        List<Integer> res = new ArrayList<>();
        while(maxIndex != -1){
            res.add(nums[maxIndex]);
            maxIndex = prev[maxIndex]; // Move backwards using the prev pointer
        }
        
        return res;
    }
}