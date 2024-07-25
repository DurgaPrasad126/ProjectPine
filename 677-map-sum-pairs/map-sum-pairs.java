class MapSum {
    Map<String, Integer> mapSum;
    public MapSum() {
        mapSum = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        mapSum.put(key, val);
    }
    
    public int sum(String prefix) {
        int result = 0;
        for(String key : mapSum.keySet()){
            if(key.startsWith(prefix)) result+=mapSum.get(key);
        }
        return result;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */