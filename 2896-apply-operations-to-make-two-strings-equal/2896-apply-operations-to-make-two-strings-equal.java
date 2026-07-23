import java.util.*;

class Solution {
    Integer[][] memo;
    List<Integer> idx;
    int x;

    public int minOperations(String s1, String s2, int x) {
        this.x = x;
        idx = new ArrayList<>();
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                idx.add(i);
            }
        }
        
        int m = idx.size();
        if (m % 2 != 0) return -1;
        if (m == 0) return 0;
        
        memo = new Integer[m][m];
        return helper(0, m - 1);
    }
    
    private int helper(int i, int j) {
        if (i > j) return 0;
        if (memo[i][j] != null) return memo[i][j];
        int o1 = x + helper(i + 1, j - 1);
        int o2 = (idx.get(i + 1) - idx.get(i)) + helper(i + 2, j);
        int o3 = (idx.get(j) - idx.get(j - 1)) + helper(i, j - 2);
        return memo[i][j] = Math.min(o1, Math.min(o2, o3));
    }
}