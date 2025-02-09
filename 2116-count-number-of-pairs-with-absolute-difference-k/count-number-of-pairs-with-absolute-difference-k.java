class Solution {
    public int countKDifference(int[] nums, int k) {
        int kPairs = 0;
        int n = nums.length;
        Map<Integer, Integer> numFreq = new HashMap<>();
        for(int i=0;i<n;i++) {
            numFreq.put(nums[i], numFreq.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : numFreq.keySet()) {
            if(numFreq.containsKey(key+k)) {
                kPairs+=(numFreq.get(key)*(numFreq.get(key+k)));
            }
        }
        return kPairs;
    }
}