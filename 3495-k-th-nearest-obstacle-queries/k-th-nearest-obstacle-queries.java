class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] res = new int[n];
        int pos = 0;
        for(int[] query : queries) {
            int distanceFromOrigin = Math.abs(query[0]) + Math.abs(query[1]);
            if(maxHeap.size() >= k && distanceFromOrigin > maxHeap.peek()) {
                res[pos++] = maxHeap.peek();
            }
            else {
                if(maxHeap.size() < k) {
                    maxHeap.offer(distanceFromOrigin);
                    res[pos++] = maxHeap.size() == k ? maxHeap.peek() : -1;
                }
                else{
                    maxHeap.poll();
                    maxHeap.offer(distanceFromOrigin);
                    res[pos++] = maxHeap.peek();
                }
            }

        }
        return res;
    }
}