class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode curr = root, a = null, b = null, prev = null;

        while(curr != null){
            TreeNode leftmost = curr.left;
            if(leftmost == null){
                if(prev != null && prev.val > curr.val){
                    if(a == null)
                    a = prev;
                    b = curr;
                }
                prev = curr;
                curr = curr.right;
            }else{
                TreeNode rmn = getRightMostNode(leftmost, curr);
                if(rmn.right == null){
                    rmn.right = curr;
                    curr = curr.left;
                }else{
                    rmn.right = null;
                      if(prev != null && prev.val > curr.val){
                    if(a == null)
                    a = prev;
                    b = curr;
                }
                prev = curr;
                    curr = curr.right;
                }
            }
        }

        if(a != null){
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }

    public TreeNode getRightMostNode(TreeNode node , TreeNode curr){
        while(node.right != null && node.right != curr){
            node = node.right;
        }
        return node;
    }
}