class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        
        Map<Integer, Integer> dist = new HashMap<>();
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            
            if (dist.containsKey(u)) continue;
            dist.put(u, d);
            
            if (graph.containsKey(u)) {
                for (int[] edge : graph.get(u)) {
                    int v = edge[0];
                    int w = edge[1];
                    if (!dist.containsKey(v)) {
                        pq.offer(new int[]{v, d + w});
                    }
                }
            }
        }
        
        if (dist.size() != n) return -1;
        
        int maxDist = 0;
        for (int d : dist.values()) {
            maxDist = Math.max(maxDist, d);
        }
        
        return maxDist;
    }
}