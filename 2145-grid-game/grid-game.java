class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] prefixSum = new long[n];
        long[] suffixSum = new long[n];

        for(int i=0;i<n;i++){
            prefixSum[i] = ((i!=0) ? prefixSum[i-1] : 0) + grid[0][i];
            suffixSum[n-i-1] = ((i!=0) ? suffixSum[n-i] : 0) + grid[1][n-i-1];
        }

        long maxScore = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            long prefSum = (prefixSum[n-1]-prefixSum[i]);
            long suffSum = (suffixSum[0]-suffixSum[i]);
            if((maxScore > prefSum || maxScore > suffSum)) {
                maxScore = Math.min(maxScore, Math.max(prefSum, suffSum));
            }
        }
        return maxScore;
    }
}