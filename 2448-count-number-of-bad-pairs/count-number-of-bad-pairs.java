class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> diffFreq = new HashMap<>();
        int n = nums.length;
        long badPairs = 0;
        for(int i=0;i<n;i++){
            badPairs+=(i-diffFreq.getOrDefault(nums[i]-i, 0));
            diffFreq.put(nums[i]-i, diffFreq.getOrDefault(nums[i]-i, 0)+1);
        }
        return badPairs;
    }
}