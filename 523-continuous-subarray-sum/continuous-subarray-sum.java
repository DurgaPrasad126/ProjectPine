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

        //O(n*n) - 94/98 TCs passed
        /*
        for(int i=0;i<nums.length-1;i++){
            long[] sums = new long[nums.length];
            long sum = nums[i];
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                sums[j] = sum;
                if(sums[j] % k == 0) return true;
            }
        }
        return false;
        */
    }
}