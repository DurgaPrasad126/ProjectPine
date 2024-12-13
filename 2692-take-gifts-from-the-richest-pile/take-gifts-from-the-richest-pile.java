class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        long sum = 0;

        for(int gift : gifts) {
            maxHeap.offer(gift);
            sum+=gift;
        }

        while(k > 0) {
            int curGift = maxHeap.poll();
            int giftsRem = (int)Math.floor(Math.sqrt(curGift));
            maxHeap.add(giftsRem);
            sum-=(curGift-giftsRem);
            k--;
        }

        
        return sum;
    }
}