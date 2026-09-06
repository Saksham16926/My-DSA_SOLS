class Solution {
    int camera = 0;
    public int minCameraCover(TreeNode root) {
        if (helper(root) == 0) {
            camera++;
        }
        return camera;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 2;
        }

        int left = helper(node.left);
        int right = helper(node.right);

        if (left == 0 || right == 0) {
            camera++;
            return 1;
        }

        if (left == 1 || right == 1) {
            return 2;
        }

        return 0;
    }
}