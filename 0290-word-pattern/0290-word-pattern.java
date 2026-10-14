class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(str.length != pattern.length()){
            return false;
        }
        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Boolean> map2 = new HashMap<>();

        for(int i = 0 ; i < pattern.length() ; i++){
            char ch = pattern.charAt(i);
            String st = str[i];
            if(map1.containsKey(ch) == true){
                if(!map1.get(ch).equals(st)){
                    return false;
                }
            }else{
                if(map2.containsKey(st) == true){
                    return false;
                }else{
                    map1.put(ch,st);
                    map2.put(st,true);
                }
            }
        }
        return true;
    }
}