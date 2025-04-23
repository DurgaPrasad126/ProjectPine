class Solution {
    private Queue<int[]> qP;
    private Queue<int[]> qV;
    private boolean[][] pacV;
    private boolean[][] atlV;
    private int[][] dir = new int[][]{{0,1}, {1,0}, {-1, 0}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        qP = new LinkedList<>();
        qV = new LinkedList<>();
        pacV = new boolean[m][n];
        atlV = new boolean[m][n];
        
        for(int j=0;j<n;j++) {
            qP.add(new int[]{0, j});
            qV.add(new int[]{m-1, j});
        }

        for(int j=0;j<m;j++) {
            qP.add(new int[]{j, 0});
            qV.add(new int[]{j, n-1});
        }

        while(!qP.isEmpty()) {
            int size = qP.size();
            for(int i=0;i<size;i++) {
                int[] point = qP.poll();
                pacV[point[0]][point[1]] = true;
                for(int d=0;d<dir.length;d++) {
                    int newX = dir[d][0] + point[0];
                    int newY = dir[d][1] + point[1];
                    if(newX >= 0 && newY >= 0 && newX < m && newY < n && 
                        heights[point[0]][point[1]] <= heights[newX][newY] && !pacV[newX][newY]) {
                            qP.add(new int[]{newX, newY});
                            pacV[newX][newY] = true;
                        }
                }
            }
        }

        while(!qV.isEmpty()) {
            int size = qV.size();
            for(int i=0;i<size;i++) {
                int[] point = qV.poll();
                atlV[point[0]][point[1]] = true;

                for(int d=0;d<dir.length;d++) {
                    int newX = dir[d][0] + point[0];
                    int newY = dir[d][1] + point[1];
                    if(newX >= 0 && newY >= 0 && newX < m && newY < n && 
                        heights[point[0]][point[1]] <= heights[newX][newY] && !atlV[newX][newY]) {
                            qV.add(new int[]{newX, newY});
                            atlV[newX][newY] = true;

                        }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) { 
                if(pacV[i][j] && atlV[i][j]) {
                    List<Integer> r = new ArrayList<>();
                    r.add(i);
                    r.add(j);
                    res.add(r);
                }
            }
        }
        return res;
    }
}