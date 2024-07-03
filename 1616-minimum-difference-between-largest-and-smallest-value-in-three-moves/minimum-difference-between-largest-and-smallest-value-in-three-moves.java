class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4) return 0;
        //if(nums.length == 5) return nums[nums.length-1]-nums[nums.length-2];
        Arrays.sort(nums);
        int n = nums.length;
        int a = nums[1]-nums[0];
        int b = nums[2] - nums[1];
        int c = nums[3] -nums[2];
        int f = nums[n-1]-nums[n-2];
        int e = nums[n-2]-nums[n-3];
        int d = nums[n-3]-nums[n-4];

        int diff = Math.max(a+b+c,a+b+f);
        diff = Math.max(diff,a+f+e);
        diff = Math.max(diff,d+e+f);

        return nums[n-1]-nums[0]-diff;
          
        //return Math.min(nums[nums.length-4]-nums[0], nums[nums.length-1]-nums[3]);
    }
}