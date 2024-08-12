class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.k = k;
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
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

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */