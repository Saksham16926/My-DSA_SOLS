class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return height(root);
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        int res = Math.max(lh,rh) + 1;
        return res;
    }
}