class Solution {
    public long maxKelements(int[] nums, int k) {
        long maxScore = 0l;
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<nums.length;i++) {
            max.offer(nums[i]);
        }

        while(k>0) {
            int curMax = max.poll();
            maxScore+=curMax;
            max.offer((int)(Math.ceil(curMax*1d/3)));
            k--;
        }
        return maxScore;
    }
}