class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n==1) return 10;
        
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 10;

        int unique = 9;
        int curr = 9;

        for(int i = 2 ; i < dp.length ; i++){
            unique = unique * curr;
            dp[i] = dp[i-1] + unique;
            curr--;
        }
        return dp[n];
    }
}