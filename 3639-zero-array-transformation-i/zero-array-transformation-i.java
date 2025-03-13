class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n];

        for(int[] query : queries) {
            prefix[query[0]] += 1;
            if(query[1] != n-1) prefix[query[1]+1] -= 1;
        }

        for(int i=0;i<n;i++){
            if(i==0) {
                if(prefix[i] < nums[i]) return false;
            }
            else {
                prefix[i]+=prefix[i-1];
                if(prefix[i] < nums[i]) return false;
            }
        }
        return true;
    }
}