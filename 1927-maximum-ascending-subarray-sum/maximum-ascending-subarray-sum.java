class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int curSum = nums[0];
        int n = nums.length;

        for(int i=0;i<n-1;i++) {
            if(nums[i] >= nums[i+1]) {
                maxSum = Math.max(maxSum, curSum);
                curSum = nums[i+1];
            }
            else {
                curSum+=nums[i+1];
            }
        }
        return Math.max(maxSum, curSum);
    }
}