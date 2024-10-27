class NumMatrix {
    int[][] prefixSum;
    int m,n;
    public NumMatrix(int[][] matrix) {
        m=matrix.length;
        n=matrix[0].length;
        prefixSum = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0) prefixSum[i][j] = matrix[i][j];
                else prefixSum[i][j] = prefixSum[i][j-1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1;i<=row2;i++){
            if(col1 == 0) sum+=(prefixSum[i][col2]);
            else sum+=(prefixSum[i][col2]-prefixSum[i][col1-1]);
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */