class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0; int maxIdx = 0;
        for(int i=0;i<nums.length;i++) {
            if(max < nums[i]) {
                max = nums[i];
                maxIdx = i;
            }
        }

        int maxLen = 0;
        int len = 0;
        while(maxIdx < nums.length) {
            if(nums[maxIdx] != max) {
                maxLen = Math.max(maxLen, len);
                len = 0;
            }
            else len++;
            maxIdx++;
        }
        return Math.max(maxLen,len);

    }
}