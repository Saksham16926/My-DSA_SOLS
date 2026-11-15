
class Solution {
    public int numOfSubarrays(int[] arr) {

        long count = 0;
        int even = 1;
        int odd = 0;

        int parity = 0;
        int MOD = 1_000_000_007;

        for (int num : arr) {

            parity = (parity + num) % 2;

            if (parity == 0) {
                count += odd;
                even++;
            } 
            else {
                count += even;
                odd++;
            }

            count %= MOD;
        }

        return (int) count;
    }
}
