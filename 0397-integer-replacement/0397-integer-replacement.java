class Solution {
    Map<Long,Integer> map = new HashMap<>();
    public int integerReplacement(int n){
        return (int) helper((long) n);
    }

    public long helper(long n){
        if(n == 1) return 0;
        if(map.containsKey(n)) return map.get(n);

        long steps = 0;
        if( n % 2 == 0){
            steps = 1 + helper(n/2);
        }else{
            steps = 1 + Math.min(helper(n + 1), helper(n - 1));
        }
        map.put(n , (int) steps);
        return steps;
    }
}