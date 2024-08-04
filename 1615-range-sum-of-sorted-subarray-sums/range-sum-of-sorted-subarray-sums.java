class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] prefixSum = new int[n*(n+1)/2];
        int pos = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++){
                sum=sum+nums[j];
                prefixSum[pos++] = sum;
            }
        }

        Arrays.sort(prefixSum);
        /*for(int i=0;i<prefixSum.length;i++){
            System.out.print(prefixSum[i] + "  ---- ");
        }*/
        int result = 0;

        for(int i=left-1; i<right;i++){
            result = (result%1000000007) + (prefixSum[i]);
        }
        return result;
    }
}