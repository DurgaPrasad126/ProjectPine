class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        //int[] replacedArray = nums;
        Map<Integer, Integer> eleToIdx = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            eleToIdx.put(nums[i], i);
        }

        for(int[] opt : operations) {
            int idx = eleToIdx.get(opt[0]);
            nums[idx] = opt[1];
            eleToIdx.put(opt[1], idx);
        }
        return nums;
    }
}