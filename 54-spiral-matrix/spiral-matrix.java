class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int i=0, j=0, cur_d = 0;
        int m = matrix.length, dm=m;
        int n = matrix[0].length, dn=n, cur=0;
        int[][] direction = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Set<String> pos = new HashSet<>();

        List<Integer> res = new ArrayList<>();
        while(cur < m*n) {
            res.add(matrix[i][j]);
            pos.add(i+"_"+j);
            int new_i = i + direction[cur_d][0];
            int new_j = j + direction[cur_d][1];

            if(new_i < 0 
                || new_j < 0
                || new_i >= dm
                || new_j >= dn
                || pos.contains(new_i+"_"+new_j)
                ) {
                    cur_d = (cur_d+1)%4;
                }
            
            i+=direction[cur_d][0];
            j+=direction[cur_d][1];

            cur++;
            
        }

       
        return res;
    }
}