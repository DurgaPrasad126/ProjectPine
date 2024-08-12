class Solution {
    PriorityQueue<Integer> pq;
    int k;
    public int findKthLargest(int[] nums, int k) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
        return pq.peek();
    }
    
    public int add(int val) {
        if(pq.isEmpty() || pq.size() < k) pq.add(val);
        else if(!pq.isEmpty() && val >= pq.peek()){
                pq.poll();
                pq.add(val);
        }

        return pq.peek();
    }
}