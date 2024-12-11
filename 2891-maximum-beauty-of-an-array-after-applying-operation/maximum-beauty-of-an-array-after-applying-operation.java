class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int maxBeauty = 0;
        int left = 0;
        for(int i=0;i<len;i++){
            while(left < i && nums[i]-nums[left] > 2*k) {
                left++;
            }
            maxBeauty = Math.max(maxBeauty, i-left+1);

        }        
        return maxBeauty;
    }
}