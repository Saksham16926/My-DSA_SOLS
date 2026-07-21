class Solution {
    List<List<Integer>> res = new ArrayList<>(); 
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, new ArrayList<>()); 
        return res;
    }

    public void helper(int[] candidates, int remain, int index, List<Integer> currentList){  
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            res.add(new ArrayList<>(currentList)); 
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            helper(candidates, remain - candidates[i], i, currentList);
            currentList.remove(currentList.size() - 1);
        }
    }
}