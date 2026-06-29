class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2 ; i < dp.length ; i++){
            int max = 0;
            for(int j = 1 ; j < i ; j++){
                max = Math.max(max,Math.max(j * (i-j) , j * dp[i-j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}