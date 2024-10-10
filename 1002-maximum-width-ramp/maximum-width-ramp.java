class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] maxSuf = new int[n];
        maxSuf[n-1] = nums[n-1];

        for(int i=n-2;i>=0;i--) maxSuf[i] = Math.max(nums[i], maxSuf[i+1]);

        int left = 0;
        int right = 0;
        int maxWidth = 0;

        while(right < n) {
            while(left < right && nums[left] > maxSuf[right]) {
                left++;
            }
            maxWidth = Math.max(maxWidth, right-left);
            right++;
        }
        return maxWidth;
    }
}