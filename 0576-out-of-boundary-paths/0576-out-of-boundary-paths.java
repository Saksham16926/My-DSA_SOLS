class Solution {
    int M = 1000000007;
    
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] memo = new Integer[m][n][maxMove + 1];
        return help(m, n, maxMove, startRow, startColumn, memo);
    }
    
    public int help(int m, int n, int moves, int r, int c, Integer[][][] memo) {
        if (r < 0 || r >= m || c < 0 || c >= n) return 1;
    
        if (moves == 0) return 0;
        
        if (memo[r][c][moves] != null) return memo[r][c][moves];
        
        long paths = 0;
        paths = (paths + help(m, n, moves - 1, r - 1, c, memo)) % M;
        paths = (paths + help(m, n, moves - 1, r + 1, c, memo)) % M; 
        paths = (paths + help(m, n, moves - 1, r, c - 1, memo)) % M; 
        paths = (paths + help(m, n, moves - 1, r, c + 1, memo)) % M; 
        
        memo[r][c][moves] = (int) paths;
        return memo[r][c][moves];
    }
}