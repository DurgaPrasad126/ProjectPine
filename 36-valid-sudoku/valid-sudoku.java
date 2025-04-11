class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        char[] values = new char[9];
        for(int i=0;i<board.length;i++) {
            values = new char[9];
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j] == '.') continue;
                if(values[(int)(board[i][j]-'0')-1] == board[i][j]) return false;
                values[(int)(board[i][j]-'0')-1] = board[i][j];
            }
        }
        values = new char[9];
        for(int i=0;i<board.length;i++) {
            values = new char[9];
            for(int j=0;j<board[0].length;j++) {
                if(board[j][i] == '.') continue;
                if(values[(int)(board[j][i]-'0')-1] == board[j][i]) return false;
                values[(int)(board[j][i]-'0')-1] = board[j][i];
            }
        }
        values = new char[9];
        // boolean[] res = new boolean[1];
        // res[0] = true;
        for(int i=0;i<board.length;i+=3) {
            for(int j=0;j<board[0].length;j+=3) {
                if(!checkSquare(i, j, board)) return false;
            }
        }
        
        return true;
    }

    public boolean checkSquare(int m, int n, char[][] board) {
        char[] values = new char[9];
        for(int i=m;i<m+3;i++) {
            for(int j=n;j<n+3;j++) {
                if(board[j][i] == '.') continue;
                if(values[(int)(board[j][i]-'0')-1] == board[j][i]) return false;
                values[(int)(board[j][i]-'0')-1] = board[j][i];
            }
        }
        return true;
    }
}