class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        for(int i=0;i<grid1.length;i++){
            for(int j=0;j<grid1[0].length;j++){
                if(grid2[i][j] == 1 && dfs(grid1, grid2, i, j)){
                    res++;
                }
            }
        }
        return res;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int i, int j){
        if(i<0 || i>= grid1.length || j<0 || j>= grid1[0].length || grid2[i][j] == 0) return true;
        if(grid2[i][j] != grid1[i][j]) return false;
        grid2[i][j] = 0;

        boolean left = dfs(grid1, grid2, i, j-1);
        boolean right = dfs(grid1, grid2, i, j+1);
        boolean top = dfs(grid1, grid2, i-1, j);
        boolean bottom = dfs(grid1, grid2, i+1, j);

        return left && right && top && bottom;
    }
}