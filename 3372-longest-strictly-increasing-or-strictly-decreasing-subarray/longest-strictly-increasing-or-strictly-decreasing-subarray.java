class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLen = 1;
        int curLen = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] < nums[i+1]) {
                ++curLen;
            }
            else {
                maxLen = maxLen < curLen ? curLen : maxLen;
                curLen = 1;
            }
        }
        maxLen = maxLen < curLen ? curLen : maxLen;
        curLen = 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]) {
                ++curLen;
            }
            else {
                maxLen = maxLen < curLen ? curLen : maxLen;
                curLen = 1;
            }
        }

        return Math.max(curLen, maxLen);
        
    }
}