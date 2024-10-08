class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lessCount = 0;
        int targetCount = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i] < target) lessCount++;
            else if(nums[i] == target) targetCount++;
        }

        List<Integer> targetIdx = new ArrayList<>();
        while(targetCount > 0) {
            targetIdx.add(lessCount++);
            targetCount--;
        }
        return targetIdx;
    }
}