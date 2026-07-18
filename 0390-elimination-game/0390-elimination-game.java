class Solution {
    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        int x = lastRemaining(n / 2);
        int y = 2 * ((n / 2) + 1 - x);
        return y;
    }
}