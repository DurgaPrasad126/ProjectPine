class NumberContainers {
    Map<Integer, Integer> idxToNum;
    Map<Integer, TreeSet<Integer>> numToIdxsMap;
    public NumberContainers() {
        idxToNum = new HashMap<>();
        numToIdxsMap = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(idxToNum.containsKey(index)) {
            int curNum = idxToNum.get(index);
            if(numToIdxsMap.get(curNum) == null || numToIdxsMap.get(curNum).size() == 0) numToIdxsMap.remove(curNum);
            else numToIdxsMap.get(curNum).remove(index);
        }
        idxToNum.put(index, number);
        numToIdxsMap.computeIfAbsent(number, l -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        if(numToIdxsMap.containsKey(number) && numToIdxsMap.get(number).size() > 0) 
            return numToIdxsMap.get(number).first();
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