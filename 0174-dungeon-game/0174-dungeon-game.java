class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
    int[][] dp = new int[dungeon.length][dungeon[0].length];
    for (int i = dp.length - 1; i >= 0; i--) {
        for (int j = dp[0].length - 1; j >= 0; j--) {
            
            if (i == dungeon.length - 1 && j == dungeon[0].length - 1) {
                dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                
            } else if (i == dungeon.length - 1) {
                dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                
            } else if (j == dungeon[0].length - 1) {
                dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                
            } else {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, min - dungeon[i][j]);
            }
        }
    }
    
    return dp[0][0];
}
}