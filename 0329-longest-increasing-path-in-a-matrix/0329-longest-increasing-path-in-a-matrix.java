class Solution {
    private int[][] memo;
    private int rows, cols;
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        rows = matrix.length;
        cols = matrix[0].length;
        memo = new int[rows][cols];
        int maxPath = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, i, j));
            }
        }

        return maxPath;
    }

    private int dfs(int[][] matrix, int row, int col) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        int maxLength = 1;

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols 
                && matrix[newRow][newCol] > matrix[row][col]) {
                maxLength = Math.max(maxLength, 1 + dfs(matrix, newRow, newCol));
            }
        }
        memo[row][col] = maxLength;
        return maxLength;
    }
}