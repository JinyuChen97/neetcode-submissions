class TimeMap {
    Map<String, List<Pair>> map = new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        List<Pair> pairs = map.get(key);
        String ans = "";
        int l=0;
        int r=pairs.size()-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            Pair p = pairs.get(mid);
            if(p.timestamp==timestamp) return p.val;
            else if(p.timestamp<timestamp){
                
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        if(l==0) return "";
        return pairs.get(l-1).val;
    }

    class Pair{
        String val;
        int timestamp;
        public Pair(String val,int timestamp){
            this.val=val;
            this.timestamp=timestamp;
        }

        public int getTime(){
            return this.timestamp;
        }
    }
}
