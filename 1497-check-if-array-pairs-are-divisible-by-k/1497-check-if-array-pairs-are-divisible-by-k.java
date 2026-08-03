class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int val : arr){
            int rem = ((val % k) + k) % k;

            int of = map.getOrDefault(rem,0);
            map.put(rem , of + 1);
        }

        for(int val : arr){
            int rem = ((val % k) + k) % k;

            if(rem == 0){
                if(map.get(rem) % 2 != 0){
                    return false;
                }
            }else if(2 * rem == k){
                 if(map.get(rem) % 2 != 0){
                    return false;
                }
            }else{
                int fr = map.get(rem);
                int of = map.getOrDefault(k - rem , 0);

                if(fr != of){
                    return false;
                }
            }
        }
        return true;
    }
}