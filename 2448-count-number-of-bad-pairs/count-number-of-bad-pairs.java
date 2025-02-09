class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> diffFreq = new HashMap<>();
        int n = nums.length;
        long badPairs = 0;
        for(int i=0;i<n;i++){
            int goodPairs = diffFreq.getOrDefault(nums[i]-i, 0);
            badPairs+=(i-goodPairs);
            diffFreq.put(nums[i]-i, goodPairs+1);
        }
        return badPairs;
    }
}