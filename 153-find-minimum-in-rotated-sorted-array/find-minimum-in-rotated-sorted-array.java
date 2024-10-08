class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length -1;

        while(lo < hi) {
            int mid = lo + (hi-lo)/2;
            System.out.println(mid);
            if(nums[lo] > nums[mid] || (nums[lo] <= nums[mid] && nums[mid] <= nums[hi])) {
                hi = mid;
            }
            else if(nums[lo] <= nums[mid] && nums[mid] >= nums[hi]) lo = mid +1;
        }

        return nums[lo];
    }
}