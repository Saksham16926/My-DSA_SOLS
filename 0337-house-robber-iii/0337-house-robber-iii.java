class Solution {
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0] , result[1]);
    }

    public int[] helper(TreeNode root){
        if(root == null){
            return new int[2];
        }

        int[] lt = helper(root.left);
        int[] rt = helper(root.right);
        int[] arr = new int[2];

        arr[0] = root.val + lt[1] + rt[1];
        arr[1] = Math.max(lt[0] , lt[1]) + Math.max(rt[0] , rt[1]);

        return arr;
    }
}