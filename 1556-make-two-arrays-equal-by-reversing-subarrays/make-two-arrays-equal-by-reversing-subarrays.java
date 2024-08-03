class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> mapt = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            mapt.put(target[i], mapt.getOrDefault(target[i],0)+1);
        }
        if(map.size() != mapt.size()) return false;
        for(int key: map.keySet()) {
            if(!mapt.containsKey(key) || map.get(key) != mapt.get(key)) return false;
        }
        return true;
    }
}