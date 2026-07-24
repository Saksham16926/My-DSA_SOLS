class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                drawTreeAndGenerateComp(isConnected, v, visited);
                count++; 
            }
        }

        return count;
    }

    public void drawTreeAndGenerateComp(int[][] isConnected, int src, boolean[] visited) {
        visited[src] = true;
        for (int nbr = 0; nbr < isConnected.length; nbr++) {
            if (isConnected[src][nbr] == 1 && !visited[nbr]) {
                drawTreeAndGenerateComp(isConnected, nbr, visited);
            }
        }
    }
}