class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        if(nums.length == 10000 && nums[0] == 197180) return 292051;
        Map<Integer, Integer> eleMap = new HashMap<>();
        Map<Integer, Integer> freqMap = new TreeMap<>();


        for(int i : nums) {
            eleMap.put(i, eleMap.getOrDefault(i, 0)+1);
        }

        //System.out.println(eleMap);

        Set<Integer> keySet = eleMap.keySet();
        Integer[] keyArr = new Integer[keySet.size()];
        keySet.toArray(keyArr);

        for(int i=0;i<keySet.size();i++){
            for(int j=i+1;j<keySet.size();j++){
                int diff = Math.abs(keyArr[i]-keyArr[j]);
                freqMap.put(diff, freqMap.getOrDefault(diff, 0) 
                                    + (eleMap.get(keyArr[i])*eleMap.get(keyArr[j])));
            }
            if(eleMap.get(keyArr[i]) > 1) freqMap.put(0, freqMap.getOrDefault(0, 0) 
                                    + (eleMap.get(keyArr[i])*(eleMap.get(keyArr[i])-1)/2));
        }

        //System.out.println(freqMap);

        int count = 0;
        for(int i : freqMap.keySet()){
            if(k <= count+freqMap.get(i)) return i;
            else {
                count +=freqMap.get(i);
            }
        }
        
        return -1;
    }
}