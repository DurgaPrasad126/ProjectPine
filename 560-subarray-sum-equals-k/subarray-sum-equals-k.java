class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n+1];
        prefixSum[0] = 0;
        int count = 0;

        for(int i=0;i<n;i++){
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                if(prefixSum[j]-prefixSum[i] == k) count++;
            }
        }

        return count;
    }
}