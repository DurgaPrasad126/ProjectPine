class Solution {
    int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int islandsCount = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    islandsCount += bfs(grid, m, n, i, j);
                }
            }
        }
        return islandsCount;
    }

    public int bfs(char[][] grid, int m, int n, int i, int j) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i,j});
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0;k<size;k++) {
                int[] curGrid = q.poll();
                for(int d = 0;d<directions.length;d++) {
                    int newX = directions[d][0] + curGrid[0];
                    int newY = directions[d][1] + curGrid[1];
                    if(newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY] && grid[newX][newY] == '1' ) {
                        q.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return 1;
    }
}