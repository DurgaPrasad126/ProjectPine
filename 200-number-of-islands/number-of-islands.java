class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int islandCount = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(!isVisited[i][j] && grid[i][j] == '1') {
                    checkIsland(grid, m, n, isVisited, i, j);
                    islandCount+=1;
                }
            }
        }
        return islandCount;
    }
    public void checkIsland(char[][] grid, int m, int n, boolean[][] isVisited, int i, int j) {
        if(i<0 || i>= m || j < 0 || j >= n || isVisited[i][j] || grid[i][j] == '0') return;
        isVisited[i][j] = true;
        checkIsland(grid, m, n, isVisited, i+1, j);
        checkIsland(grid, m, n, isVisited, i-1, j);
        checkIsland(grid, m, n, isVisited, i, j+1);
        checkIsland(grid, m, n, isVisited, i, j-1);
    }
}