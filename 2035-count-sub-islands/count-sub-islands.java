class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        boolean[][] isVisited = new boolean[m][n];
        int res = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j] == 1 && !isVisited[i][j] && dfs(grid1, grid2, i, j, m, n, isVisited)){
                    res++;
                }
            }
        }

        return res;
    }
    public boolean dfs(int[][] grid1, int[][] grid2, int i, int j, int m, int n, boolean[][] isVisited) {
        if(i<0 || i>= m || j< 0 || j>= n 
            || grid2[i][j] == 0 || isVisited[i][j]) 
                return true;

        if(grid2[i][j] != grid1[i][j]) return false;
        
        isVisited[i][j] = true;

        boolean top = dfs(grid1, grid2, i-1, j, m, n, isVisited);
        boolean down = dfs(grid1, grid2, i+1, j, m, n, isVisited);
        boolean left = dfs(grid1, grid2, i, j-1, m, n, isVisited);
        boolean right = dfs(grid1, grid2, i, j+1, m, n, isVisited);
        return top && down && left && right;
    }
}