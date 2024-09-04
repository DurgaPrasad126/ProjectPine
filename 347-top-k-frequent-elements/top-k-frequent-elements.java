class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int key : freqMap.keySet()) {
            minHeap.offer(new int[]{key, freqMap.get(key)});
            if(minHeap.size() > k) minHeap.poll();
        }

        int[] res = new int[k];
        int pos = 0;
        while(k>0) {
            res[pos++] = minHeap.poll()[0];
            k--;
        }
        return res;
    }
}