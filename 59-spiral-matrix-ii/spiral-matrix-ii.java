class Solution {
    public int[][] generateMatrix(int n) {
        int i=0, j=0, cur_d = 0;
        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int[][] res = new int[n][n];
        for(int[] wor : res) Arrays.fill(wor, -1);
        int val = 1;
        while(val <= n*n) {
            res[i][j] = val;
            int new_i = i + direction[cur_d][0];
            int new_j = j + direction[cur_d][1];

            if( new_i < 0 || new_j < 0
                || new_i >= n
                || new_j >= n
                || res[new_i][new_j] != -1) cur_d = (cur_d+1)%4;
            
            i+=direction[cur_d][0];
            j+=direction[cur_d][1];

            val+=1;
        }
        return res;
    }
}