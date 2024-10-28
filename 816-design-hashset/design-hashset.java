class MyHashSet {
    int[] set = new int[1000001];
    public MyHashSet() {
        Arrays.fill(set, -1);
    }
    
    public void add(int key) {
        set[key] = key;
    }
    
    public void remove(int key) {
        set[key] = -1;
    }
    
    public boolean contains(int key) {
        return set[key] == key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */