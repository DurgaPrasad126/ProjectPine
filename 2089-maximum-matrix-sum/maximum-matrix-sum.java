class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int negatives = 0;
        int min = Integer.MAX_VALUE;
        long sum = 0;
        for(int[] row : matrix) {
            for(int i : row) {
                if(i < 0) {
                    negatives++;
                }
                min = Math.min(min, Math.abs(i));
                sum+=Math.abs(i);
            }
        }

        return negatives%2 == 0? sum : (sum-2*min);
    }
}