class Solution {
    public List<Integer> grayCode(int n) {
      
        if (n == 1) {
            List<Integer> lol = new ArrayList<>();
            lol.add(0); 
            lol.add(1); 
            return lol;
        }
        
        List<Integer> prev = grayCode(n - 1);
        
       
        List<Integer> res = new ArrayList<>(prev);

        int mask = 1 << (n - 1);

        for (int i = prev.size() - 1; i >= 0; i--) {
            res.add(prev.get(i) | mask);
        }
        
        return res;
    }
}