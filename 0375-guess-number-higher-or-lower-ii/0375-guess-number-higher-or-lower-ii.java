class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(1, n, dp);
    }

    public int helper(int start, int end, int[][] dp){
        if(start >= end){
            return 0;
        }

        if(dp[start][end] != 0){
            return dp[start][end];
        }

        int res = Integer.MAX_VALUE;

        for(int k = start ; k <= end ; k++){
            int worst = k + Math.max(helper(start, k - 1, dp), helper(k + 1, end, dp));

            res = Math.min(res, worst);
        }

        dp[start][end] = res;
        return dp[start][end];
    }
}