class Robot {
    int[][] grid;
    int[][] directions = {{1,0}, {0,-1}, {-1,0}, {0,1}};

    int[] pos = {0,0};
    int width;
    int height;
    int dirIndex;
    public Robot(int width, int height) {
        this.grid = new int[width][height];
        this.width = width;
        this.height = height;
    }
    
    public void step(int num) {
        num%=2*((width-1)+(height-1));
        if(num == 0) num = 2*((width-1)+(height-1));
        for(int i=0;i<num;i++){
            int[] direction = directions[dirIndex];
            int nextX = pos[0] + direction[0];
            int nextY = pos[1] + direction[1];
            if(nextX < 0 || nextY < 0 || nextX >= width || nextY >= height) {
                dirIndex = (dirIndex+3)%4;
                i--;
            }
            if(nextX >= 0 && nextX < width) pos[0] = nextX;
            if(nextY >= 0 && nextY < height) pos[1] = nextY;
        }
    }
    
    public int[] getPos() {
        return pos;
    }
    
    public String getDir() {
        switch(dirIndex) {
            case 0 :
                return "East";
            case 1 : 
                return "South";
            case 2 : 
                return "West";
            case 3 : 
                return "North";
            default :
                return "East";
        }
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */