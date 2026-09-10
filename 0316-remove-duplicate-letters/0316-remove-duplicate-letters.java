class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (seen[curr - 'a']) {
                continue;
            }
            while (!st.isEmpty() && curr < st.peek() && lastIndex[st.peek() - 'a'] > i) {
                seen[st.pop() - 'a'] = false; 
            }
            st.push(curr);
            seen[curr - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}