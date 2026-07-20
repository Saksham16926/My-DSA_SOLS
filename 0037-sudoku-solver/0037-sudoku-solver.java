class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int i, int j) {
        if (i == 9) {
            return true;
        }

        int ni = 0;
        int nj = 0;

        if (j == 8) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] != '.') {
            return solve(board, ni, nj);
        } else {
            for (int po = 1; po <= 9; po++) {
                char c = (char) (po + '0'); 

                if (isValid(board, i, j, c)) {
                    board[i][j] = c;
                    
                    if (solve(board, ni, nj)) {
                        return true;
                    }
            
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }

    public boolean isValid(char[][] board, int x, int y, char c) {
        for (int j = 0; j < 9; j++) {
            if (board[x][j] == c) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][y] == c) {
                return false;
            }
        }
        int smi = (x / 3) * 3;
        int smj = (y / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + smi][j + smj] == c) {
                    return false;
                }
            }
        }
        
        return true;
    }
}