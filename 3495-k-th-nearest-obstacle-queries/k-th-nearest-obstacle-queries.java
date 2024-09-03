class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        int[] res = new int[n];
        int pos = 0;
        for(int[] query : queries) {
            int distanceFromOrigin = Math.abs(query[0]) + Math.abs(query[1]);
            if(maxHeap.size() < k) {
                maxHeap.offer(distanceFromOrigin);
            }
            else if(distanceFromOrigin < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(distanceFromOrigin);
            }

            if(maxHeap.size() == k) {
                res[pos++] = maxHeap.peek();
            }
            else res[pos++] = -1;
        }
        return res;
    }
}