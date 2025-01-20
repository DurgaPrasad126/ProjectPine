class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, int[]> valToIdx = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                valToIdx.put(mat[i][j], new int[]{i,j});
            }
        }

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        Arrays.fill(rowCount, n);
        Arrays.fill(colCount, m);

        for(int i=0;i<arr.length;i++){
            int[] idx = valToIdx.get(arr[i]);
            rowCount[idx[0]]--;
            colCount[idx[1]]--;
            if(rowCount[idx[0]] == 0 || colCount[idx[1]] == 0) return i;
        }
        return -1;
    }
}