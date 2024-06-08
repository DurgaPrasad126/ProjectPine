class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Long, Long> map = new HashMap<>(Map.of(0l,0l));
        long sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(!map.containsKey(sum%k)) map.put(sum%k, (long)i+1);
            else {
                if(map.get(sum%k) < i) return true;
            }
        }
        return false;
    }
}