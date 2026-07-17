import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        boolean[] cols = new boolean[n];
        boolean[] nd = new boolean[2 * n - 1];
        boolean[] rd = new boolean[2 * n - 1];

        solve(board, 0, cols, nd, rd, res);
        
        return res;
    }

    private void solve(char[][] board, int row, boolean[] cols, boolean[] nd, boolean[] rd, List<List<String>> res) {
        if (row == board.length) {
            List<String> validBoard = new ArrayList<>();
            for (char[] rowChars : board) {
                validBoard.add(new String(rowChars));
            }
            res.add(validBoard);
            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (!cols[col] && !nd[row + col] && !rd[row - col + board.length - 1]) {
                board[row][col] = 'Q';
                cols[col] = true;
                nd[row + col] = true;
                rd[row - col + board.length - 1] = true;
        
                solve(board, row + 1, cols, nd, rd, res);

                board[row][col] = '.';
                cols[col] = false;
                nd[row + col] = false;
                rd[row - col + board.length - 1] = false;
            }
        }
    }
}