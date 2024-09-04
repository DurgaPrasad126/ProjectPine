class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for(String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(
            (e1, e2) -> {
                int v1 = e1.getValue();
                int v2 = e2.getValue();

                return v1==v2 ? e2.getKey().compareTo(e1.getKey()) : v1-v2;
            }
        );


        List<String> res = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if(minHeap.size() > k) minHeap.poll();
        }

        while(k > 0) {
            res.add(minHeap.poll().getKey());
            k--;
        }
        Collections.reverse(res);

        return res;
    }
}