class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer,Integer> ele = new HashMap<>();
        for(int i : arr) ele.put(i, ele.getOrDefault(i, 0)+1);

        for(int i : arr) {
            if(i == 0 && ele.get(i) >= 2) return true; 
            else if(i!=0 && ele.containsKey(2*i)) return true;
        }
        return false;
    }
}