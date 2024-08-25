class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0] == 0 ? a[1]-b[1] : a[0]-b[0]);
        int n = nums.length;
        int[][] input = new int[n][2];

        for(int i=0;i<n;i++) {
            input[i][0] = nums[i];
            input[i][1] = i;

            minHeap.add(input[i]);
        }

        while(k > 0) {
            int[] curMinNum = minHeap.poll();
            curMinNum[0] = curMinNum[0]*multiplier;
            minHeap.add(curMinNum);
            k--;
        }

        while(!minHeap.isEmpty()) {
            int[] curEle = minHeap.poll();
            nums[curEle[1]] = curEle[0];
        }
        return nums;
    }
}