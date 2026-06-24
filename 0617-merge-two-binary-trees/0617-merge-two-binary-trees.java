class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(root1);
        q2.offer(root2);

        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();

            node1.val += node2.val;

            if(node1.left == null){
                node1.left = node2.left;
            }else if(node2.left != null){
                q1.offer(node1.left);
                q2.offer(node2.left);
            }

            if(node1.right == null){
                node1.right = node2.right;
            }else if(node2.right != null){
                q1.offer(node1.right);
                q2.offer(node2.right);
            }
            
        }
         return root1;
    }
    }
    
