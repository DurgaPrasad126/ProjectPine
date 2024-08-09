class Solution {
    public String tictactoe(int[][] moves) {
        int n = 3;
        int[] rows = new int[n];
        int[] column = new int[n];
        int diag = 0;
        int antidiag = 0;


        for(int i=0;i<moves.length;i++){
                if(i%2 == 0) {
                    rows[moves[i][0]]++;
                    column[moves[i][1]]++;
                    if(moves[i][0] == moves[i][1]) diag++;
                    if(moves[i][0] == n-moves[i][1]-1) antidiag++;
                }
                else {  
                    rows[moves[i][0]]--;
                    column[moves[i][1]]--;
                    if(moves[i][0] == moves[i][1]) diag--;
                    if(moves[i][0] == n-moves[i][1]-1) antidiag--;
                }

                if(rows[moves[i][0]] == n || column[moves[i][1]] == n || diag == n || antidiag == n) return "A";
                else if(rows[moves[i][0]] == -n || column[moves[i][1]] == -n || diag == -n || antidiag == -n) return "B";

        }
        return moves.length != 9 ? "Pending" : "Draw";
    }
}