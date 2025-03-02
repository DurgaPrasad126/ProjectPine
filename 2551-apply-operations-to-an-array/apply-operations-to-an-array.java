class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int pos = 0;

        for(int i=0;i<n-1;i++) {
            if(nums[i]!= 0 &&(nums[i] == nums[i+1])) {
                res[pos++] = nums[i] + nums[i];
                i++;
            }
            else if(nums[i] != 0) res[pos++] = nums[i];
        }
        if(nums[n-1] != nums[n-2]) res[pos++] = nums[n-1];
        return res;
    }
}