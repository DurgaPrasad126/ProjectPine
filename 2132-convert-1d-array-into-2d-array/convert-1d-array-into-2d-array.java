class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length) return new int[][]{};
        int[][] res = new int[m][n];
        int len = original.length;
        
        int row = 0;
        int col = 0;

        int pos = 0;

        while(pos < len) {
            res[row][col++] = original[pos++];
            if(col == n) {
                row++;
                col=0;
            }
        }
        return res;
    }
}