class Solution {
    public boolean winnerOfGame(String colors) {
        int aCube = 0, bCube = 0;
        char[] ch = colors.toCharArray();
        for(int i=0;i<colors.length()-2;i++) {
            if(ch[i] == ch[i+1] && ch[i+1] == ch[i+2] && ch[i+2] == 'A') aCube++;
            else if(ch[i] == ch[i+1] && ch[i+1] == ch[i+2] && ch[i+2] == 'B') bCube++;
        }
        return aCube > bCube;
    }
}