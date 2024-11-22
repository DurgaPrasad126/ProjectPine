class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long fairpairs = 0;

        for(int i=0;i<nums.length;i++){
            fairpairs+=countFairPairsForNum(nums, i+1, lower-nums[i], upper-nums[i]);
        }
        return fairpairs;
    }

    public long countFairPairsForNum(int[] nums, int low1, int lower, int upper) {
        long pairs = 0;
        int low = low1, high = nums.length-1;
        int lowIdx = 0, highIdx = 0;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(nums[mid] >= lower) {
                high = mid-1;
            }
            else low = mid+1;
        }
        lowIdx = low;
        low = low1;high = nums.length-1;
        while(low<=high) {
            int mid = high + (low-high)/2;
            if(nums[mid] <= upper) {
                low = mid+1;
            }
            else high = mid-1;
        }
        highIdx = low;
        System.out.println(highIdx + " --- " + lowIdx);
        return (long)(highIdx-lowIdx);
    }
}