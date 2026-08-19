class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        int min = Integer.MAX_VALUE;

        for(int i = 1 ; i < res.size() ; i++){
            min = Math.min(min, res.get(i) - res.get(i-1));
        }

        return min;
    }

    public void helper(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }

        helper(res, root.left);
        res.add(root.val);
        helper(res, root.right);
    }
}