class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int x = firstLen;
        int y = secondLen;

        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        int sum = 0;
        int[] arr = nums;
        int n = arr.length;

        // dealing with dp1

        for(int i = 0 ; i < dp1.length ; i++){
            if(i < x){
                sum += arr[i];
                dp1[i] = sum;
            }else{
                sum += arr[i] - arr[i-x];
                dp1[i] = Math.max(sum , dp1[i-1]);
            }
        }

        sum = 0;
        for(int i = n-1 ; i >= 0 ; i--){
            if(i >= n - y){
                sum += arr[i];
                dp2[i] = sum;
            }else{
                sum += arr[i] - arr[i + y];
                dp2[i] = Math.max(sum , dp2[i + 1]);
            }
        }

        int ans = 0;
        for(int i = x-1 ; i < dp1.length - y ; i++){
            ans = Math.max(ans , dp1[i] + dp2[i + 1]);
        }

         dp1 = new int[nums.length];
        dp2 = new int[nums.length];
        sum = 0;

        for(int i = 0 ; i < dp1.length ; i++){
            if(i < y){
                sum += arr[i];
                dp1[i] = sum;
            }else{
                sum += arr[i] - arr[i-y];
                dp1[i] = Math.max(sum , dp1[i-1]);
            }
        }

        sum = 0;
        for(int i = n-1 ; i >= 0 ; i--){
            if(i >= n - x){
                sum += arr[i];
                dp2[i] = sum;
            }else{
                sum += arr[i] - arr[i + x];
                dp2[i] = Math.max(sum , dp2[i + 1]);
            }
        }

        for(int i = y-1 ; i < dp1.length - x ; i++){
            ans = Math.max(ans , dp1[i] + dp2[i + 1]);
        }
        return ans;
    }
}