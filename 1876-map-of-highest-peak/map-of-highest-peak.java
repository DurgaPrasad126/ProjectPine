class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] heights = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[m][n];
        int[][] directions = {{-1,0}, {0,1}, {1,0}, {0,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j] == 1) {
                    q.add(new int[]{i,j});
                    isVisited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int xpos = cur[0];
            int ypos = cur[1];

            for(int i=0;i<4;i++) {
                int nX = xpos + directions[i][0];
                int nY = ypos + directions[i][1];
                if(nX >= 0 && nY >= 0 && nX <= m-1 && nY <= n-1 && !isVisited[nX][nY]) {
                    heights[nX][nY]=1+heights[xpos][ypos];
                    isVisited[nX][nY]=true;
                    q.add(new int[]{nX, nY});
                }
            }
        }
        return heights;
    }
}