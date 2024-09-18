class SnapshotArray {
    Map<Integer, TreeMap<Integer, Integer>> snapshot;
    int snap_id;

    public SnapshotArray(int length) {
        snapshot = new HashMap<>();
        for(int i=0;i<length;i++) {
            snapshot.put(i, new TreeMap<>());
            snapshot.get(i).put(0,0);
        }
        snap_id = 0;
    }
    
    public void set(int index, int val) {
        snapshot.get(index).put(snap_id, val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        return snapshot.get(index).floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */