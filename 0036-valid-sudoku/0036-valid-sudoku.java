       class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] minbox = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            minbox[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;

                int bidx = (i / 3) * 3 + (j / 3);

                if (row[i].contains(c) || col[j].contains(c) || minbox[bidx].contains(c)) {
                    return false;
                }

                row[i].add(c);
                col[j].add(c);
                minbox[bidx].add(c);
            }
        }

        return true;
    }
}
    
