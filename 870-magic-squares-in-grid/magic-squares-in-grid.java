class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m < 3 || n < 3) return 0;

        int count = 0;

        for(int i=0;i<m-2;i++){
            for(int j=0;j<n-2;j++){
                Set<Integer> dist = new HashSet<>();
                boolean isInvalid = false;
                for(int k=0;k<=2;k++){
                    for(int l=0;l<=2;l++){
                        if(dist.contains(grid[i+k][j+l]) || grid[i+k][j+l] == 0 || grid[i+k][j+l] > 9) {
                            isInvalid = true;
                            break;
                        }
                        dist.add(grid[i+k][j+l]);
                    }
                    if(isInvalid) break;
                }
                if(isInvalid) continue;
                int rowSum = grid[i][j] + grid[i][j+1] + grid[i][j+2];
                int rowSum2 = grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2];
                int rowSum3 = grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2];
                int colSum = grid[i][j] + grid[i+1][j] + grid[i+2][j];
                int colSum2 = grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1];
                int colSum3 = grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2];
                int diagSum = grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2];
                int antiDiagSum = grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j];
                
                if(rowSum == colSum 
                    && colSum == diagSum 
                    && diagSum == antiDiagSum
                    && antiDiagSum == rowSum2
                    && rowSum2 == rowSum3
                    && rowSum3 == colSum2
                    && colSum2 == colSum3) {
                    
                    count++;
                }
            }
        }
        return count;
    }
}