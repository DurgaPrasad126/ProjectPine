class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        int len = nums.length;
        for(int i=0;i<len-2;i++){
            if(2*(nums[i]+nums[i+2]) == nums[i+1]) count++;
        }
        return count;
    }
}