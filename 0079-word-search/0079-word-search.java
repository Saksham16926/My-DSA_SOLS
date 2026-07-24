class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, boolean[][] visited, String word, int row, int col, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length 
            || visited[row][col] || board[row][col] != word.charAt(idx)) {
            return false;
        }

        visited[row][col] = true;
        boolean found = helper(board, visited, word, row - 1, col, idx + 1) || 
                        helper(board, visited, word, row + 1, col, idx + 1) || 
                        helper(board, visited, word, row, col - 1, idx + 1) || 
                        helper(board, visited, word, row, col + 1, idx + 1);   
        visited[row][col] = false;

        return found;
    }
}