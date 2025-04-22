class Solution {
    int[][] dir = new int[][] {{0,1}, {-1,0}, {0,-1}, {1,0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
               if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }

        if(q.isEmpty()) {
            int foundOne = 0;
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(grid[i][j] == 1) foundOne = 1;
                }
            }
            return foundOne == 1 ? -1 : 0;
        }

        int minutes = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0;k<size;k++) {
                int[] point = q.poll();
                for(int d=0;d<dir.length;d++) {
                    int newX = point[0] + dir[d][0];
                    int newY = point[1] + dir[d][1];
                    if(newX >= 0 && newY >= 0 && newX < m && newY < n && grid[newX][newY] == 1) {
                        q.add(new int[]{newX, newY});
                        grid[newX][newY] = 2;
                    }
                }
            }
            minutes++;
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return minutes-1;
    }
}