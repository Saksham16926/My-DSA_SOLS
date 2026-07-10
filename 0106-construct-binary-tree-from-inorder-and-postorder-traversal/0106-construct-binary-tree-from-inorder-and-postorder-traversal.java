class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        return helper(inorder, 0, n-1, postorder, 0, n-1);
    }

    public TreeNode helper(int[] inorder, int insi, int inei, int[] postorder, int posi, int poei){
        if(insi > inei) return null;

        int idx = insi;
        while(inorder[idx] != postorder[poei]) idx++;

        int cols = idx - insi;

        TreeNode node = new TreeNode(postorder[poei]);

        node.left = helper(inorder, insi, idx - 1, postorder, posi, posi + cols - 1);

        node.right = helper(inorder, idx + 1, inei, postorder, posi + cols, poei - 1);

        return node;
    }
}