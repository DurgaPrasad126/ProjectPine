class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        Set<Integer> minSet = new HashSet<>();
        for(int i=0;i<m;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<n;j++) {
                min = min > matrix[i][j] ? matrix[i][j] : min;
            }
            minSet.add(min);
        }


        int[] maxEle = new int[n];
        for(int i=0;i<n;i++){
            int max = Integer.MIN_VALUE;
            for(int j=0;j<m;j++) {
                max = max < matrix[j][i] ? matrix[j][i] : max;
            }
            maxEle[i] = max;
        }

        for(int i=0;i<n;i++) {
            if(minSet.contains(maxEle[i])) result.add(maxEle[i]);
        }

        return result;


    }
}