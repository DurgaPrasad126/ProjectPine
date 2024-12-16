class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        Queue<int[]> q = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0] - b[0]);
        for(int i=0;i<nums.length;i++){
            q.add(new int[]{nums[i], i});
        }

        while(k > 0) {
            int[] cur = q.poll();
            cur[0]*=multiplier;
            nums[cur[1]] = cur[0];
            q.add(cur);
            k--;
        }
        return nums;
    }
}