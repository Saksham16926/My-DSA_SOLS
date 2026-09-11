class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> used  = new HashSet<>();
        int n = digits.length;

        for (int hun = 0; hun < n; hun++) {
            if (digits[hun] == 0) continue;

            for (int tens = 0; tens < n; tens++) {
                if (tens == hun) continue;

                for (int ones = 0; ones < n; ones++) {
                    if (ones == hun || ones == tens) continue;

                    if (digits[ones] % 2 != 0) continue;

                    int num = digits[hun] * 100 + digits[tens] * 10 + digits[ones];
                    used.add(num);
                }
            }
        }

        return used.size();
    }
}