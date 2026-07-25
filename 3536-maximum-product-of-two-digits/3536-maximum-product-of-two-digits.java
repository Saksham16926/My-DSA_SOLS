class Solution {
    public int maxProduct(int n) {
        int[] arr = String.valueOf(n).chars().map(c -> c - '0').toArray();
        Arrays.sort(arr);

            return arr[arr.length - 1] * arr[arr.length - 2];
    }
}