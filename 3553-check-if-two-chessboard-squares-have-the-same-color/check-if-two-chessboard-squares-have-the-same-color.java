class Solution {
    int[][] chessboard;
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        chessboard = new int[8][8];
        boolean isWhite = true;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                chessboard[i][j] = isWhite ? 0 : 1;
                isWhite = !isWhite;
            }
            isWhite=!isWhite;
        }
        return chessboard[(int)(coordinate1.charAt(0)-'a')][(int)(coordinate1.charAt(1)-'0')-1]
                == chessboard[(int)(coordinate2.charAt(0)-'a')][(int)(coordinate2.charAt(1)-'0')-1];
    }
}