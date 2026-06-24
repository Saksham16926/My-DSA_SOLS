class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        
        if (root == null) {
            return 0;
        }
        
        if(root.left == null && root.right == null){
           if(root.val >= low && root.val <= high){
            return root.val;
           }else{
            return 0;
           }
        }

        int leftsum = rangeSumBST(root.left, low, high);
        int rightsum = rangeSumBST(root.right, low, high);

        if(root.val >= low && root.val <= high){
            return leftsum + rightsum + root.val;
        }
        
       return leftsum + rightsum;

    }
}