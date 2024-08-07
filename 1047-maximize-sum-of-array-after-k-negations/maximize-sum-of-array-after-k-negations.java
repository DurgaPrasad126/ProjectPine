class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n && k > 0;i++){
            if(nums[i]<0) {
                nums[i] = -nums[i];
                k--;
            }
        }
       
        if(k%2!=0) {
            Arrays.sort(nums);
            nums[0]=-nums[0];
        }
        int sum = 0;
        for(int i:nums) sum+=i;
        return sum;
    }
}