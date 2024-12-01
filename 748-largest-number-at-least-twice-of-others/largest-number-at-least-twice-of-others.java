class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        int maxIdx  = 0;
        int max1 = -1;
        int max2 = -2;
        for(int i=0;i<n;i++){
            if(max1 < nums[i]) {
                max2 = max1;
                max1 = nums[i];
                maxIdx = i;
            }
            else if(max2 < nums[i]) {
                max2 = nums[i];
            }
        }
        return max1 >= 2*max2 ? maxIdx : -1;
    }
}