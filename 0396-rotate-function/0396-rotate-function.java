class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int n = nums.length;
        long cur = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            cur += i * nums[i];
        }
        long res = cur;
        for (int i = 1; i < n; i++) {
            cur = cur - sum + n * nums[i - 1];
            res = Math.max(res, cur);
        }

        return (int) res;
    }
}