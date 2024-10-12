class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int low = 0;
        int high = nums.length - 1;
        int res[] = new int[2];
        res[0] = findLeftIdx(nums, target, low, high);
        if(res[0] == -1) return new int[]{-1,-1};
        res[1] = findRightIdx(nums, target, low, high);
        return res;
    }
    public int findLeftIdx(int[] nums, int target, int low, int high) {
        while(low < high) {
            int mid = low+(high-low)/2;
            if(mid == 0 && nums[mid] == target) return mid;
            if(mid != 0 && nums[mid] == target && nums[mid-1] < target) return mid;
            if(nums[mid] >= target) {
                high = mid;
            }
            else if(nums[mid] < target) {
                low = mid+1;
            }
        }
        return nums[high] == target ? high : -1;
    }

    public int findRightIdx(int[] nums, int target, int low, int high) {
        while(low < high) {
            int mid = low+(high-low)/2;
            if(mid == nums.length-1 && nums[mid] == target) return mid;
            if(mid != nums.length-1 && nums[mid] == target && nums[mid+1] > target) return mid;
            if(nums[mid] > target) {
                high = mid;
            }
            else if(nums[mid] <= target) {
                low = mid+1;
            }
        }
        return nums[low] == target ? low : -1;
    }
}