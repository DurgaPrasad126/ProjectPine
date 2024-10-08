class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> targetIdx = new ArrayList<>();

        int pos = 0;
        while(pos < nums.length && nums[pos] != target) pos++;

        while(pos < nums.length && nums[pos] == target) {
            targetIdx.add(pos);
            pos++;
        }        
        return targetIdx;
    }
}