class TimeMap {
    class Pair{
        String value;
        int time;
        Pair(String value, int time){
            this.value = value;
            this.time = time;
        }
    }
    HashMap<String,List<Pair>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);
        int low = 0;
        int high = list.size() - 1;
        int ans = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(list.get(mid).time <= timestamp){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return (ans == -1) ? "" : list.get(ans).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */