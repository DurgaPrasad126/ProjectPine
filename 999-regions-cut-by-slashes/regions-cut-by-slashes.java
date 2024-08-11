class Solution {
    public int regionsBySlashes(String[] grid) {
        int n =  grid.length;
        int[][] adjM = new int[3*n][3*n];

        for(int i=0;i<n;i++){
            
            for(int j=0;j<n;j++){
                if(grid[i].charAt(j) == '\\'){
                    int ni = 3*i;
                    int nj = 3*j;
                    adjM[ni][nj] = 1;
                    adjM[ni+1][nj+1] = 1;
                    adjM[ni+2][nj+2] = 1;
                }
                else if(grid[i].charAt(j) == '/'){
                    int ni = 3*i+2;
                    int nj = 3*j+2;
                    adjM[ni][nj-2]=1;
                    adjM[ni-1][nj-1] = 1;
                    adjM[ni-2][nj] = 1;
                }
            }
        }

        int count = 0;
        for(int i=0; i<3*n;i++){
            for(int j=0;j<3*n;j++){
                if(adjM[i][j] == 0) {
                    DFS(adjM, i, j, 3*n);
                    count++;
                }
            }
        }

        return count;
    }

    public void DFS(int[][] adjM, int i, int j, int n){
        if(i < 0 || j < 0 || i>=n || j >= n || adjM[i][j] == 1) return;

        adjM[i][j] = 1;
        DFS(adjM, i+1, j, n);
        DFS(adjM, i-1, j, n);
        DFS(adjM, i, j-1, n);
        DFS(adjM, i, j+1, n);
    }
}