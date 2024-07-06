class Solution {
    public int passThePillow(int n, int time) {
        int rem = time%(n-1);
        time = time/(n-1);
        return time%2 == 0 ? rem+1 : n-rem;
    }
}