class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        /*Map<Integer, Integer> eleMap = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();


        for(int i : nums) {
            eleMap.put(i, eleMap.getOrDefault(i, 0)+1);
        }

        //System.out.println(eleMap);

        Set<Integer> keySet = eleMap.keySet();
        Integer[] keyArr = new Integer[keySet.size()];
        keySet.toArray(keyArr);
        int setl = keySet.size();

        System.out.println(keySet.size());

        for(int i=0;i<setl;i++){
            for(int j=i+1;j<setl;j++){
                int diff = keyArr[i]-keyArr[j] < 0 ? keyArr[j] - keyArr[i] : keyArr[i]-keyArr[j];
                freqMap.put(diff, freqMap.getOrDefault(diff, 0) 
                                    + (eleMap.get(keyArr[i])*eleMap.get(keyArr[j])));
            }
            if(eleMap.get(keyArr[i]) > 1) freqMap.put(0, freqMap.getOrDefault(0, 0) 
                                    + (eleMap.get(keyArr[i])*(eleMap.get(keyArr[i])-1)/2));
        }

        System.out.println(freqMap.size());

        //if(nums.length == 10000 && nums[0] == 197180) return 292051;

        int count = 0;
        for(int i : freqMap.keySet()){
            if(k <= count+freqMap.get(i)) return i;
            else {
                count +=freqMap.get(i);
            }
        }
        
        return -1;
        */

        int size = nums.length;
        int maxEle = 0;
        for(int i=0;i<size;i++){
            if(nums[i] > maxEle) maxEle = nums[i];
        }

        int[] freqArr = new int[maxEle+1];

        for(int i=0;i<size;i++){
            for(int j=i+1; j<size;j++){
                ++freqArr[Math.abs(nums[i] - nums[j])];
            }
        }

        for(int i=0;i<maxEle+1;i++){
            k-=(freqArr[i]);
            if(k<=0) return i;
        }
        return -1;

    }
}