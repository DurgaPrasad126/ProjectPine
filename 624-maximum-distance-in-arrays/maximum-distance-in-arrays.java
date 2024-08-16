class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDist = 0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        List<Integer> array = new ArrayList<>();
        int len = 0;
        for(int i=0;i<arrays.size();i++){
            array = arrays.get(i);
            len = array.size();
            maxHeap.add(new int[]{i, array.get(len-1)});
            minHeap.add(new int[]{i, array.get(0)});
        }
        //System.out.println(maxHeap);
        //System.out.println(minHeap);

        int[] max = maxHeap.poll();
        int[] min = minHeap.poll();

        if(max[0] == min[0]) {
            if(Math.abs(max[1]-minHeap.peek()[1]) < Math.abs(min[1]-maxHeap.peek()[1])){
                max = maxHeap.poll();
            }
            else min = minHeap.poll();
        } 
        return max[1]-min[1]; 
    }
}