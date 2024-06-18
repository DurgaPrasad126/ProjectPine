class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] workers) {
        int maxProfitObtained = 0;
        int n = difficulty.length;
        int[][] diffProfit = new int[n][2];
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            diffProfit[i][0] = difficulty[i];
            diffProfit[i][1] = profit[i];
        }

        Arrays.sort(diffProfit, (a,b) -> a[0]-b[0]);
        for(int i=0;i<n-1;i++){
            diffProfit[i+1][1] = Math.max(diffProfit[i][1], diffProfit[i+1][1]);
        }
        for(int worker : workers) {
            int nearestDiffIndex = getNearestDifficultyIndex(diffProfit, worker);
            maxProfitObtained+=nearestDiffIndex;
        }

        return maxProfitObtained;
    }

    private int getNearestDifficultyIndex(int[][] diffProfit, int worker){
        int low = 0;
        int high = diffProfit.length-1;
        int maxProfit = 0;
        while(low<=high) {
            int mid = low+ (high-low)/2;
            if(diffProfit[mid][0] <= worker) {
                maxProfit = Math.max(maxProfit, diffProfit[mid][1]);
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return maxProfit;
    }
}