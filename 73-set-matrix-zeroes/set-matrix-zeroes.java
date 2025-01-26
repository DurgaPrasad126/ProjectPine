class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row10 = false;
        boolean col10 = false;
        for(int i=0;i<n;i++) {
            if(matrix[0][i] == 0) {
                row10 = true;
                break;
            }
        }
        for(int j=0;j<m;j++) {
            if(matrix[j][0] == 0) {
                col10 = true;
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        

        for(int i=1;i<m;i++){
            if(matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            } 
        }

        for(int i=1;i<n;i++){
            if(matrix[0][i] == 0) {
                for(int j=0;j<m;j++){
                    matrix[j][i] = 0;
                }
            }
        }

        if(row10) Arrays.fill(matrix[0], 0);
        if(col10) {
            for(int i=0;i<m;i++){
                matrix[i][0] = 0;
            }
        }
    }
}