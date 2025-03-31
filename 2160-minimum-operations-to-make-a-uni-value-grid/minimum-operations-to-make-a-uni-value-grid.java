class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int mn = m*n;
        int[] gridEle = getSortedEle(grid);
       
        int uniValue = getMedian(gridEle);

        int minOperations = 0;

        for(int i=0;i<mn;i++) {
            if(Math.abs((uniValue-gridEle[i])) % x == 0) {
                minOperations += (Math.abs((uniValue-gridEle[i])) / x);
            }
            else {
                return -1;
            }
        }
        return minOperations;
    }

    public int[] getSortedEle(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] gridEle = new int[m*n];
        int pos = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                gridEle[pos++] = grid[i][j];
            }
        }
        Arrays.sort(gridEle);
        return gridEle;
    }

    public int getMedian(int[] gridEle) {
        int n = gridEle.length;
        return gridEle[(n/2)];
    }
}