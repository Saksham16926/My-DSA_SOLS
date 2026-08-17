class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (que.size() > 0) {
            int size = que.size();
            
            int levmax = Integer.MIN_VALUE; 
            
            for (int i = 0; i < size; i++) {
                TreeNode temp = que.poll();
                
                levmax = Math.max(levmax, temp.val);
                
                if (temp.left != null) que.add(temp.left);
                if (temp.right != null) que.add(temp.right);
            }
            res.add(levmax);
        }
        
        return res;
    }
}