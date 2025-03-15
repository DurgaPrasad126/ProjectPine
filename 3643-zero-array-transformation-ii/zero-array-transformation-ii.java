class Solution {
    int[] nums;
    int[][] queries;
    public int minZeroArray(int[] nums, int[][] queries) {
        int sum = 0;
        boolean nonZero=false;
        for(int num : nums) {
            if(num!=0) nonZero=true;
            sum+=num;
        }
        if(!nonZero && sum == 0) return 0;
        
        this.nums = nums;
        this.queries = queries;
        int n = queries.length;
        int low = 0;
        int high = n-1;
        int minK = -1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(isZeroArray(mid)) {
                high = mid-1;
                minK = mid+1;
            }
            else {
                low = mid+1;
            }
        }
        return minK;
    }

    public boolean isZeroArray(int k) {
        int n = nums.length;
        int[] prefix = new int[n];

        for(int i=0;i<=k;i++) {
            prefix[queries[i][0]] += queries[i][2];
            if(queries[i][1] != n-1) prefix[queries[i][1]+1] -= queries[i][2];
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