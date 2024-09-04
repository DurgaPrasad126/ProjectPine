class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        int n = messages.length;
        Map<String, Integer> freqMap = new HashMap<>();
        int max = 0;
        String res = "";
        for(int i=0;i<n;i++){
            freqMap.put(senders[i], freqMap.getOrDefault(senders[i], 0) + getWordCount(messages[i]));
            int curCount = freqMap.get(senders[i]);
            if(curCount > max) {
                max=curCount;
                res = senders[i];
            }
            else if(curCount == max && senders[i].compareTo(res) >= 1) res = senders[i];
        }

        return res;

        /*PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
            (e1, e2) -> {
                int v1 = e1.getValue();
                int v2 = e2.getValue();

                return v1==v2 ? e2.getKey().compareTo(e1.getKey()) : v2-v1;
            }
        );

        for(Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(entry);
        }

        return maxHeap.peek().getKey();
        */
    }

    public int getWordCount(String message) {
        String[] splitStrings = message.split(" ");
        return splitStrings.length;
    }
}