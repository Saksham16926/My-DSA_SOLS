class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        helper(root, val, depth, 1);
        
        return root;
    }
    
    private void helper(TreeNode node, int val, int depth, int currentDepth) {
        if (node == null) {
            return;
        }
        
        if (currentDepth == depth - 1) {
            TreeNode oldLeft = node.left;
            TreeNode oldRight = node.right;
            
            node.left = new TreeNode(val);
            node.right = new TreeNode(val);
            
            node.left.left = oldLeft;
            node.right.right = oldRight;

            return;
        }
        helper(node.left, val, depth, currentDepth + 1);
        helper(node.right, val, depth, currentDepth + 1);
    }
}