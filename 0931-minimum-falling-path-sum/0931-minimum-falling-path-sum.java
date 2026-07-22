class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length == 0 && matrix[0].length == 0){
            return 0;
        }
        
        int[][] dp = new int[matrix.length][matrix[0].length];
         int sum = Integer.MAX_VALUE;
        for(int i = dp.length - 1 ; i>=0 ; i--){
            for(int j = dp[0].length - 1 ; j>=0 ; j--){
                if(i == dp.length - 1){
                    dp[i][j] = matrix[i][j];
                }else if(j == 0){
                    dp[i][j] = Math.min(dp[i + 1][j],dp[i + 1][j + 1]) + matrix[i][j];
                }else if(j == dp[0].length - 1){
                    dp[i][j] = Math.min(dp[i + 1][j],dp[i + 1][j - 1]) + matrix[i][j];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i + 1][j + 1],dp[i + 1][j - 1]) , dp[i + 1][j])  + matrix[i][j];
                }

                if(i == 0){
                    if(dp[i][j] < sum){
                        sum = dp[i][j];
                    }
                }
            }
        }
        return sum;
    }
}