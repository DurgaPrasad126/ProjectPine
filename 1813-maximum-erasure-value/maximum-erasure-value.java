class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        //char[] ch = s.toCharArray();

        //Map<Integer, Integer> index = new HashMap<>();
        int[] index = new int[10001];
        Arrays.fill(index,-1);

        int pos = 0, curLen = 0, maxLen = Integer.MIN_VALUE;
        while(pos < n) {
            if(index[nums[pos]] != -1) {
                maxLen = Math.max(curLen, maxLen);
                curLen = 0;
                pos = index[nums[pos]]+1;
                //index.put(ch[pos-1], pos-1);
                Arrays.fill(index, -1);
                //index.clear();
            }
            curLen+=nums[pos];
            index[nums[pos]] = pos;
            pos++;
        }
        return Math.max(maxLen, curLen);
    }
}