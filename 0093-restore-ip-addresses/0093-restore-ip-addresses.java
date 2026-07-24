import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        int[] segments = new int[1]; 

        helper(res, s, segments, 0, "");
        return res;
    }

    public void helper(List<String> res, String s, int[] segments, int idx, String sf) {
        if (segments[0] == 4) {
            if (idx == s.length()) {
                res.add(sf.substring(0, sf.length() - 1));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (idx + len > s.length()) {
                break;
            }

            String part = s.substring(idx, idx + len);

            if (part.startsWith("0") && len > 1) {
                break;
            }

            if (Integer.parseInt(part) <= 255) {
                segments[0]++;
                
                helper(res, s, segments, idx + len, sf + part + ".");
                segments[0]--;
            }
        }
    }
}