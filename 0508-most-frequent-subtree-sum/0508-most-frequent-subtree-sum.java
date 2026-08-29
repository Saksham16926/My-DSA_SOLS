class Solution {
    int maxFreq = 0; 

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> countMap = new HashMap<>();
        calculateSubtreeSum(root, countMap);
        
        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                resultList.add(entry.getKey());
            }
        }
        
        int[] res = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            res[i] = resultList.get(i);
        }
        
        return res;
    }

    private int calculateSubtreeSum(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }

        int leftSum = calculateSubtreeSum(node.left, map);
        int rightSum = calculateSubtreeSum(node.right, map);
        
        int currentSum = node.val + leftSum + rightSum;
        int currentFreq = map.getOrDefault(currentSum, 0) + 1;
        map.put(currentSum, currentFreq);
        
        maxFreq = Math.max(maxFreq, currentFreq);
        return currentSum;
    }
}