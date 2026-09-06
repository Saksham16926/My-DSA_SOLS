class Solution {
    private int idx = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        return dfs(traversal, 0);
    }

    private TreeNode dfs(String s, int expectedDepth) {
        int n = s.length();
        if (idx >= n) return null;

        int dashes = 0;
        while (idx + dashes < n && s.charAt(idx + dashes) == '-') {
            dashes++;
        }

        if (dashes != expectedDepth) {
            return null;
        }

        idx += dashes;

        int val = 0;
        while (idx < n && Character.isDigit(s.charAt(idx))) {
            val = val * 10 + (s.charAt(idx) - '0');
            idx++;
        }

        TreeNode node = new TreeNode(val);
        node.left = dfs(s, expectedDepth + 1);
        node.right = dfs(s, expectedDepth + 1);

        return node;
    }
}