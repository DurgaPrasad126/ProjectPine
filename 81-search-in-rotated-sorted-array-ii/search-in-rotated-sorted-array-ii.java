class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length -1;

        while(lo < hi) {
            int mid = lo + (hi-lo)/2;

            if(nums[mid] == target) return true;

            if(nums[lo] < nums[mid]) {
                if(nums[lo] <= target && target <= nums[mid]) hi = mid;
                else lo = mid+1;
            }
            else if (nums[lo] > nums[mid]){
                if(nums[mid] <= target && target <= nums[hi]) lo = mid;
                else hi = mid-1;
            }
            else lo++;
            
        }

        return nums[lo] == target ? true : false;
    }
}