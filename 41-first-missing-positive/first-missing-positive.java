class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : nums) {
            if( i > 0) {
                set.add(i);
            }
        }
        for(int i : set) minHeap.add(i);
        System.out.println(minHeap);

        int pos = 1;
        while(!minHeap.isEmpty() && pos == minHeap.peek()) {
            minHeap.poll();
            pos++;
        }
        return pos;
    }
}