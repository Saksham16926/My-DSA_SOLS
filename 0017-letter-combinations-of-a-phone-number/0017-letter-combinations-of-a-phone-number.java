class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        Map<Character, String> dialpad = new HashMap<>();
        dialpad.put('2', "abc");
        dialpad.put('3', "def");
        dialpad.put('4', "ghi");
        dialpad.put('5', "jkl");
        dialpad.put('6', "mno");
        dialpad.put('7', "pqrs");
        dialpad.put('8', "tuv");
        dialpad.put('9', "wxyz");

        helper(digits, dialpad, 0, new StringBuilder(), res);
        return res;
    }

    public void helper(String digits, Map<Character, String> dialpad, int idx, StringBuilder path, List<String> res) {
        if (idx == digits.length()) {
            res.add(path.toString());
            return;
        }
        char currentDigit = digits.charAt(idx);
      
        String letters = dialpad.get(currentDigit);

        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            helper(digits, dialpad, idx + 1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}