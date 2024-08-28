class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> freqSum = new HashMap<>();
        int res = 0, sum=0;
        freqSum.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(freqSum.containsKey(sum-k)) {
                res+=freqSum.get(sum-k);
            }
            freqSum.put(sum, freqSum.getOrDefault(sum, 0)+1);
        }
        return res;
    }
}