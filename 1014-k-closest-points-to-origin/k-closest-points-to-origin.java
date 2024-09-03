class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b[2], a[2]));
        int[][] res = new int[k][2];
        int pos = 0;
        for(int[] query : points) {
            double distanceFromOrigin = Math.sqrt(query[0]*query[0] + query[1]*query[1]);
            if(maxHeap.size() < k) {
                maxHeap.offer(new double[]{query[0], query[1], distanceFromOrigin});
            }
            else if(distanceFromOrigin < maxHeap.peek()[2]){
                maxHeap.poll();
                maxHeap.add(new double[]{query[0], query[1], distanceFromOrigin});
            }
        }

        while(!maxHeap.isEmpty()){
            double[] curPoint = maxHeap.poll();
            res[pos++] = new int[]{(int)curPoint[0], (int)curPoint[1]};
        }
        return res;
    }
}