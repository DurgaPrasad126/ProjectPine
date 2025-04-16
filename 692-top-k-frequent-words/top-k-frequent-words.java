class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String word : words) freq.put(word, freq.getOrDefault(word, 0) + 1);
        List<Word> wordss = new ArrayList<>();
        for(String word : freq.keySet()) wordss.add(new Word(word, freq.get(word)));
        PriorityQueue<Word> minHeap = new PriorityQueue<>((a,b) -> b.count==a.count ? b.word.compareTo(a.word) : a.count-b.count);
        for(Word word : wordss) {
            // minHeap.offer(word);
            minHeap.offer(word);
            if(minHeap.size() > k) minHeap.poll();
        }
        List<String> res = new ArrayList<>();
        while(k > 0 && !minHeap.isEmpty()) {
            res.add(minHeap.poll().word);
            k--;
        }
        Collections.reverse(res);
        return res;
    }
    class Word {
        String word;
        int count;
        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}