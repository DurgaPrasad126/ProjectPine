class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[][] res = new int[2][colsum.length];
        int sum = 0;
        for(int i : colsum) sum+=i;

        if(upper+lower != sum) return result;
        for(int i=0;i<2;i++){
            for(int j=0;j<colsum.length;j++){
                if(upper > 0 && colsum[j] == 2) {
                    //row.add(1);
                    res[i][j] = 3;
                    upper--;
                    colsum[j]--;
                }
                else res[i][j] = colsum[j];
            }
        }
        System.out.println(upper);
        for(int i=0;i<colsum.length;i++){
                System.out.print(res[0][i] + " --- ");
        }


            for(int i=0;i<colsum.length;i++){
                if( upper > 0 && res[0][i] == 1) {
                    res[0][i]=1;
                    upper--;
                    colsum[i]--;
                }
                else if(res[0][i] == 3) {
                    res[0][i]=1;
                }
                else res[0][i] = 0;
            }
            res[1] = colsum;

            if(upper > 0) return result;
            //result.add(row);
            for(int i=0;i<2;i++){
                List<Integer> row = new ArrayList<>();
                for(int j=0;j<colsum.length;j++){
                    row.add(res[i][j]);
                }
                result.add(row);
            }
        
        return result;


    }
}