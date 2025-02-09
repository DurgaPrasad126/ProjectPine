class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> diffFreq = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            diffFreq.put(nums[i]-i, diffFreq.getOrDefault(nums[i]-i, 0)+1);
        }

        long res = (1l*n*(n-1))/2;

        for(int key : diffFreq.keySet()){
            int val = diffFreq.get(key);
            res-=(1l*val*(val-1))/2;
        }
        return res;
    }
}