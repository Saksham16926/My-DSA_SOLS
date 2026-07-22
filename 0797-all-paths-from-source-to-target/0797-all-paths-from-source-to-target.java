class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        curr.add(0);

        helper(res, graph, 0, graph.length - 1, curr);
        return res;
    }

    public void helper(List<List<Integer>> res, int[][] graph, int src, int des, List<Integer> curr){
        if(src == des){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int neighbour : graph[src]){
            curr.add(neighbour);
            helper(res, graph, neighbour, des, curr);
            curr.remove(curr.size() - 1);
        }
    }
}