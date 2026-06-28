class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers,1);

        long[] dp = new long[n + 1];
        dp[1] = 1;

        for(int  i = 2 ; i < dp.length ; i++){
            long min = Integer.MAX_VALUE;
            for(int j = 0 ; j < primes.length ; j++){
                min = Math.min(min, primes[j] * dp[pointers[j]]);
            }
            dp[i] = min;

            //incrementing the pointer

            for(int j  = 0 ; j < primes.length ; j++){
                if(dp[i] == primes[j] * dp[pointers[j]]){
                    pointers[j]++;
                }
            }
        }
        return (int) dp[n];
    }
}