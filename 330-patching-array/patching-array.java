class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        int idx = 0;
        long miss = 1;

        while(miss <= n) {
            if(idx<nums.length && nums[idx] <= miss) {
                miss+=nums[idx];
                idx++;
            }
            else {
                patches++;
                miss+=miss;
            }
        }
        return patches;
    }
}