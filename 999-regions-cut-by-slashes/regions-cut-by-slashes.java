class Solution {
    public int regionsBySlashes(String[] grid) {
        int[][] mat = new int[grid.length * 3][grid.length * 3];
        boolean[][] visited = new boolean[mat.length][mat.length];
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length(); j++){
                char ch = grid[i].charAt(j);
                if(ch == '/'){
                    int r = i * 3;
                    int c = (j * 3) + 2;
                    mat[r][c] = 1;
                    mat[r + 1][c - 1] = 1;
                    mat[r + 2][c - 2] = 1;
                }else if(ch == '\\'){
                    int r = i * 3;
                    int c = j * 3;
                    mat[r][c] = 1;
                    mat[r + 1][c + 1] = 1;
                    mat[r + 2][c + 2] = 1;
                }
            }
        }
        // for(int[] ar : mat){
        //     System.out.println(Arrays.toString(ar));
        // }

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(!visited[i][j] && mat[i][j] != 1){
                    dfs(i, j, visited, mat);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int r, int c, boolean[][] visited, int[][] mat){
        if(r < 0 || r == mat.length || c < 0 || c == mat.length || visited[r][c] || mat[r][c] == 1){
            return;
        }
        visited[r][c] = true;
        dfs(r + 1, c, visited, mat);
        dfs(r - 1, c, visited, mat);
        dfs(r, c + 1, visited, mat);
        dfs(r, c - 1, visited, mat);
    }
}