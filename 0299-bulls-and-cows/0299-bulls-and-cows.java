class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] freq = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                freq[secret.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                int digit = guess.charAt(i) - '0';

                if (freq[digit] > 0) {
                    cow++;
                    freq[digit]--;
                }
            }
        }

        return bull + "A" + cow + "B";
    }
}