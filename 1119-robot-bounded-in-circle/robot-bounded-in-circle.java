class Solution {
    public boolean isRobotBounded(String instructions) {
        char[] ch = instructions.toCharArray();
        int[] curPos = {0,0};
        char curDir = 'N';
        for(int i=0;i<ch.length;i++){
            if(ch[i] == 'G'){
                if(curDir == 'N') curPos[1]++;
                else if(curDir == 'E') curPos[0]++;
                else if(curDir == 'W') curPos[0]--;
                else if(curDir == 'S') curPos[1]--;
            }
            else if(ch[i] == 'L') {
                if(curDir == 'N') curDir = 'W';
                else if(curDir == 'E') curDir = 'N';
                else if(curDir == 'W') curDir = 'S';
                else if(curDir == 'S') curDir = 'E';
            }
            else if(ch[i] == 'R') {
                if(curDir == 'N') curDir = 'E';
                else if(curDir == 'E') curDir = 'S';
                else if(curDir == 'W') curDir = 'N';
                else if(curDir == 'S') curDir = 'W';
            } 
        }
        return (curPos[0] == 0 && curPos[1] == 0) || curDir != 'N';
    }
}