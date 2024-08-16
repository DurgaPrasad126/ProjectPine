class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        return minimumPathSum(grid, dp, 0, 0, m, n, 0);
    }

    public int minimumPathSum(int[][] grid, int[][] dp, int i, int j, int m ,int n, int points){
        if(i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != 0) return dp[i][j];

        if(i==m-1 && j==n-1) {
            points+=grid[m-1][n-1];
            return points;
        }

        points+=grid[i][j] + Math.min(minimumPathSum(grid, dp, i, j+1, m, n, points), 
                        minimumPathSum(grid, dp, i+1, j, m, n, points));
        dp[i][j] = points;
        return points;

    }
}