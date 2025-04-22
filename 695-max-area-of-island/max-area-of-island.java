class Solution {
    int[][] directions = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(calculateIslandArea(grid, i, j, m, n), maxArea);
                }
            }
        }
        return maxArea;
    }

    public int calculateIslandArea(int[][] grid, int i, int j, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        int area = 1;
        q.add(new int[]{i,j});
        grid[i][j]=0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0;k<size;k++) {
                int[] curCorr = q.poll();
                for(int d=0;d<directions.length;d++) {
                    int newX = curCorr[0] + directions[d][0];
                    int newY = curCorr[1] + directions[d][1];

                    if(newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] == 1) {
                        q.add(new int[]{newX, newY});
                        area+=1;
                        grid[newX][newY] = 0;
                    }

                }
            }
        }
        return area;
    }
}