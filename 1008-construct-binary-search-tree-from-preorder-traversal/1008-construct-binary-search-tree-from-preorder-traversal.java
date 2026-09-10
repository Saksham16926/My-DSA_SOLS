class Solution {
    public int idx = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        int lr = -(int)1e9 - 1;
        int rr = (int)1e9 + 1;

        return helper(preorder,lr,rr);
    }
    
    public TreeNode helper(int[] preorder, int lr, int rr){
        if(idx >= preorder.length || preorder[idx] < lr || preorder[idx] > rr){
            return null;
        }

        TreeNode node = new TreeNode(preorder[idx++]);
        node.left = helper(preorder, lr, node.val);
        node.right = helper(preorder, node.val, rr);
        return node;
    }

}