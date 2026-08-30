class Solution {
    
    public static class vPair {
        TreeNode node = null;
        int hl = 0;

        vPair(TreeNode node, int hl){
            this.node = node;
            this.hl = hl;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
         List<List<Integer>> res = new ArrayList<>();
         if (root == null) return res;

         LinkedList<vPair> que = new LinkedList<>();
         HashMap<Integer, List<Integer>> map = new HashMap<>();
         int maxhl = 0;
         int minhl = 0;

         que.addLast(new vPair(root, 0));
         
         while(que.size() != 0){
            int size = que.size();
            HashMap<Integer, List<Integer>> tempMap = new HashMap<>();

            while(size-- > 0){
                vPair rp = que.removeFirst();

                maxhl = Math.max(maxhl, rp.hl);
                minhl = Math.min(minhl, rp.hl);
                
                tempMap.putIfAbsent(rp.hl, new ArrayList<>());
                tempMap.get(rp.hl).add(rp.node.val);

                if(rp.node.left != null) que.addLast(new vPair(rp.node.left, rp.hl - 1));
                if(rp.node.right != null) que.addLast(new vPair(rp.node.right, rp.hl + 1));
            }
            
            for (int key : tempMap.keySet()) {
                map.putIfAbsent(key, new ArrayList<>());
                List<Integer> levelNodes = tempMap.get(key);
                
                Collections.sort(levelNodes);
                map.get(key).addAll(levelNodes); 
            }
         }

         for(int i = minhl ; i <= maxhl ; i++){
            res.add(map.get(i));
         }
         
         return res;
    }
}