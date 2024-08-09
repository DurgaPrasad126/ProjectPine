class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if(grid.length < 3 || grid[0].length < 3) return 0;
        
        int magicBoxCount = 0;
        for(int i=0; i<=(grid.length-3); i++){
            for(int j=0; (j<=grid[0].length-3); j++){
                if(isAMagicBox(grid, i, j)) 
                    magicBoxCount++;
            }
        }
        
        return magicBoxCount;
    }
    
    private boolean isAMagicBox(int[][] grid, int x, int y){
        if(grid[x+1][y+1] != 5) return false;
        
        if(grid[x][y] %2 != 0 || grid[x+2][y] %2 != 0  ||
           grid[x][y+2] %2 != 0 || grid[x+2][y+2] %2 != 0 )
        {
            return false;
        }
        
        if(grid[x+1][y] %2 == 0 || grid[x][y+1] %2 == 0  ||
           grid[x+1][y+2] %2 == 0 || grid[x+2][y+1] %2 == 0 )
        {
            return false;
        }
        
        if ( (grid[x][y] + grid[x][y+1] + grid[x][y+2]) != 15 || 
            (grid[x+2][y] + grid[x+2][y+1] + grid[x+2][y+2]) != 15 || 
            (grid[x][y] + grid[x+1][y] + grid[x+2][y]) != 15) 
        {
            return false;
        }
        
        return true;
        
    }
    
}