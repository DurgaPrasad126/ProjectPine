class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue mq = new MonotonicQueue();
        int winMax = Integer.MIN_VALUE;
        int n = nums.length;

        int[] res = new int[n-k+1];
        int pos = 0;

        for(int i=0;i<n;i++) {
            if(i<k-1) {
                mq.add(nums[i]);
            }
            else if (i == k-1){
                mq.add(nums[i]);
                res[pos++] = (mq.max());
            }
            else {
                mq.add(nums[i]);
                mq.poll(nums[i-k]);
                res[pos++] = (mq.max());
            }
        }
        return res;
    }
    public class MonotonicQueue  {
        LinkedList<Integer> q;

        MonotonicQueue() {
            q = new LinkedList<>();
        }

        public void add(int num) {
            while(!q.isEmpty() && q.getLast() < num) {
                q.pollLast();
            }
            q.offerLast(num);
        }

        public int max() {
            return q.getFirst();
        }

        public void poll(int prevEle) {
            if(q.getFirst() == prevEle) q.pollFirst();
        }

    }
}