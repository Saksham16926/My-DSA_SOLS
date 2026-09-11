class Solution {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        long totalPairs = 0;
        long remainingNodes = n;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long componentSize = getComponentSize(graph, i, visited);
                remainingNodes -= componentSize; 
                totalPairs += (componentSize * remainingNodes);
            }
        }
        
        return totalPairs;
    }
    private long getComponentSize(List<Integer>[] graph, int src, boolean[] visited) {
        visited[src] = true;
        long count = 1;
        
        for (int neighbor : graph[src]) {
            if (!visited[neighbor]) {
                count += getComponentSize(graph, neighbor, visited);
            }
        }
        
        return count;
    }
}