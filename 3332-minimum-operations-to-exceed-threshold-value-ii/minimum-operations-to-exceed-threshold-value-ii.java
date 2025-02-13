class Solution {
    public int minOperations(int[] nums, int k) {
        int minOperations = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue(Comparator.naturalOrder());
        for(int num : nums) minHeap.offer(1l*num);

        while(minHeap.size() >= 2 && minHeap.peek() < k) {
            long el1 = minHeap.poll();
            long el2 = minHeap.poll();
            minHeap.offer(el1*2 + el2);
            minOperations++;
        }

        return minOperations;
    }
}