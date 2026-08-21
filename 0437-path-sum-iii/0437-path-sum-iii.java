class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }

        helper(root, 0, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;

    }

    public void helper(TreeNode node, long sum, int target){
        if(node == null){
            return;
        }

        sum += node.val;

        if(sum == target){
            count++;
        }

        helper(node.left, sum, target);
        helper(node.right, sum, target);

    }
}