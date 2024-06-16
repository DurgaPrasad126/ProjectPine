class Solution {
    public int numEnclaves(int[][] grid) {
        int landCells = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if((i==0 || i== m-1 || j==0 || j== n-1) && grid[i][j] == 1) dfs(grid, i, j, m, n);
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) landCells++;
            }
        }
        return landCells;
    }

    public void dfs(int[][] grid, int i, int j, int m, int n) {

        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0) return;
        grid[i][j] = 0;

        dfs(grid, i+1, j, m, n);
        dfs(grid, i-1, j, m, n);
        dfs(grid, i, j+1, m, n);
        dfs(grid, i, j-1, m, n);
    }
}