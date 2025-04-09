class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = computeFreq(nums);
        System.out.println(freq);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int key : freq.keySet()) {
            if(minHeap.size() == k && minHeap.peek()[1] < freq.get(key)) {
                minHeap.poll();
            }
            if(minHeap.size() < k) minHeap.offer(new int[] {key, freq.get(key)});
        } 

        int[] res = new int[k];
        int pos = 0;
        while(!minHeap.isEmpty()) {
            res[pos++] = minHeap.poll()[0];
        }
        return res;
    }
    public Map<Integer, Integer> computeFreq(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return freq;
    }
}