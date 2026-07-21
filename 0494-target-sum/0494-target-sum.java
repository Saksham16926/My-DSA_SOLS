class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int ts = 0;
        for (int num : nums) {
            ts += num;
        }
        if (ts < Math.abs(target) || (target + ts) % 2 != 0) {
            return 0;
        }

        int subtar = (target + ts) / 2;
        
        int[][] dp = new int[nums.length + 1][subtar + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= subtar; j++) {
                
                dp[i][j] = dp[i - 1][j];
                
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
                
            }
        }
        return dp[nums.length][subtar];
    }
}