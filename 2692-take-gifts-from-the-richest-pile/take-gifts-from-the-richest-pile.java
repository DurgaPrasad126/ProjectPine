class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        long remGifts = 0l;

        for(int gift : gifts) {
            maxHeap.offer(gift);
        }

        while(k > 0) {
            int giftsRem = (int)Math.floor(Math.sqrt(maxHeap.poll()));
            maxHeap.add(giftsRem);
            k--;
        }

        while(!maxHeap.isEmpty()) {
            remGifts+=maxHeap.poll();
        }
        return remGifts;
    }
}