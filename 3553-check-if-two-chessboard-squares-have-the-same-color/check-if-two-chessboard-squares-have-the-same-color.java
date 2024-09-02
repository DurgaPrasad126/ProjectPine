class Solution {
    public boolean checkTwoChessboards(String a, String b) {
        
        return (a.charAt(0) % 2 != a.charAt(1) % 2) == (b.charAt(0) % 2 != b.charAt(1) % 2);
    }
}