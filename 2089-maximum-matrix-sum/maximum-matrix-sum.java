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
                i=Math.abs(i);
                min = i < min ? i : min;//Math.min(min, Math.abs(i));
                sum+=i;
            }
        }

        return negatives%2 == 0? sum : (sum-2*min);
    }
}