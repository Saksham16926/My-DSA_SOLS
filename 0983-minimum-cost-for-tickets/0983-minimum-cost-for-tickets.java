class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            int cost1 = costs[0] + dp[i + 1];
            int cost2 = costs[1] + dp[next(days, i, 7)];
            int cost3 = costs[2] + dp[next(days, i, 30)];
            
            dp[i] = Math.min(cost1, Math.min(cost2, cost3));
        }
        
        return dp[0];
    }
    public int next(int[] days, int i, int duration) {
        int j = i;
        while (j < days.length && days[j] < days[i] + duration) {
            j++;
        }
        return j;
    }
}