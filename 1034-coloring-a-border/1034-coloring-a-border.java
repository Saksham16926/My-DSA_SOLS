class Solution {
    public class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int ocolor = grid[row][col];
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        ArrayList<Pair> lis = new ArrayList<>();

        populate(grid, row, col, ocolor, visited, lis);

        int m = grid.length;
        int n = grid[0].length;

        for (Pair p : lis) {
            int r = p.i;
            int c = p.j;

            if (r == 0 || r == m - 1 || c == 0 || c == n - 1 ||
                !visited[r - 1][c] || 
                !visited[r + 1][c] || 
                !visited[r][c - 1] || 
                !visited[r][c + 1]) {
                
                grid[r][c] = color;
            }
        }

        return grid;
    }

    public void populate(int[][] grid, int x, int y, int ocolor, boolean[][] visited, ArrayList<Pair> lis) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] || grid[x][y] != ocolor) {
            return;
        }

        visited[x][y] = true;
        lis.add(new Pair(x, y));

        populate(grid, x + 1, y, ocolor, visited, lis);
        populate(grid, x - 1, y, ocolor, visited, lis);
        populate(grid, x, y + 1, ocolor, visited, lis);
        populate(grid, x, y - 1, ocolor, visited, lis);
    }
}