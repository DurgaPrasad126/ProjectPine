class NumberContainers {
    Map<Integer, Integer> idxToNum;
    Map<Integer, TreeSet<Integer>> numToIdxsMap;
    public NumberContainers() {
        idxToNum = new HashMap<>();
        numToIdxsMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        idxToNum.put(index, number);
        numToIdxsMap.computeIfAbsent(number, l -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        if(numToIdxsMap.containsKey(number) && numToIdxsMap.get(number).size() > 0) {
            TreeSet<Integer> idxSet = numToIdxsMap.get(number);
            int idx = idxSet.first();
            while(idxToNum.containsKey(idx) && idxToNum.get(idx) != number) {
                idxSet.remove(idx);
                if(idxSet.size() == 0) {
                    numToIdxsMap.remove(number);
                    return -1;
                }
                idx = idxSet.first();
            }
            numToIdxsMap.put(number, idxSet);
            return idx;
        }
        else
            return -1;

    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */