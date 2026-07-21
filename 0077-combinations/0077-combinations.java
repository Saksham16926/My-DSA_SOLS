class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,n,k,1,new ArrayList<>());
        return res; 
    }

    public void helper(List<List<Integer>> res, int n , int k , int idx , List<Integer> lis){
        if(lis.size() == k){
            res.add(new ArrayList<>(lis));
            return;
        }

        for(int i = idx ; i <= n ; i++){
            lis.add(i);
            helper(res, n, k, i + 1, lis);
            lis.remove(lis.size()-1);
        }
    }
}