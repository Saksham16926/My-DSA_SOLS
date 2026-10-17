public class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n < k) return 0;
        if (k <= 1) return n;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (freq[c - 'a'] < k) {
                int j = i + 1;
                while (j < n && freq[s.charAt(j) - 'a'] < k) {
                    j++;
                }

                int left = longestSubstring(s.substring(0, i), k);
                int right = longestSubstring(s.substring(j), k);

                return Math.max(left, right);
            }
        }
        return n;
    }
}