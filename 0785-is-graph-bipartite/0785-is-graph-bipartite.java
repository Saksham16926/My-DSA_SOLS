class Solution {
   
   static class Pair{
    int v;
    int level;

    public Pair(int v, int level){
        this.v = v;
        this.level = level;
    }
   }
   
   public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        boolean res = true;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        for(int i = 0 ; i < n ; i++){
            if(visited[i] == -1){
                boolean isBipar = check(graph, i, visited);
                if(isBipar == false){
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    public boolean check(int[][] graph, int src, int[] visited){
        ArrayDeque<Pair> q = new  ArrayDeque<>();
        q.add(new Pair(src, 0));

        while(q.size() > 0){
            Pair rem = q.removeFirst();

            if(visited[rem.v] != -1){
                if(rem.level != visited[rem.v]){
                    return false;
                }
            }else{
                visited[rem.v] = rem.level;
            }

            int len = graph[rem.v].length;

            for(int i = 0 ; i < len ; i++){
                if(visited[graph[rem.v][i]] == -1){
                    q.add(new Pair(graph[rem.v][i], rem.level + 1));
                }
            }
        }
        return true;
    }
}