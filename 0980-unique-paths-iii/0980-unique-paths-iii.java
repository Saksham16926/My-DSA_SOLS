class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zeroCount = 0;
        int startX = 0;
        int startY = 0;
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    zeroCount++;
                } else if (grid[r][c] == 1) {
                    startX = r;
                    startY = c;
                }
            }
        }
        
        return helper(grid, startX, startY, zeroCount);
    }
    
    private int helper(int[][] grid, int r, int c, int zeros) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1) {
            return 0;
        }
        
        if (grid[r][c] == 2) {
            return zeros == 0 ? 1 : 0; 
        }
        
        int temp = grid[r][c];
        grid[r][c] = -1; 
        
        int nextZeros = (temp == 0) ? zeros - 1 : zeros;
        int totalPaths = helper(grid, r + 1, c, nextZeros) +
                         helper(grid, r - 1, c, nextZeros) +
                         helper(grid, r, c + 1, nextZeros) +
                         helper(grid, r, c - 1, nextZeros);

        grid[r][c] = temp;
        
        return totalPaths;
    }
}