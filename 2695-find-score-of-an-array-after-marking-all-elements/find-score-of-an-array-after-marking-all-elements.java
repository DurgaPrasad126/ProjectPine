class Solution {
    public long findScore(int[] nums) {
        int len = nums.length;
        int marked = 2;
        boolean[] visited = new boolean[len];
        Queue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);

        for(int i=0;i<len;i++){
            minHeap.add(new int[]{nums[i],i});
        }

        long score = 0l;
        while(!minHeap.isEmpty()) {
            int[] curInt = minHeap.poll();
            if(!visited[curInt[1]]) {
                score+=curInt[0];
                for(int i=1;i<marked;i++){
                    if(curInt[1] + i < len) {
                        visited[i+curInt[1]] = true;
                    }
                    if(curInt[1] - i >= 0) {
                        visited[curInt[1]-i] = true;
                    }
                }
            }
        }
        return score;
    }
}