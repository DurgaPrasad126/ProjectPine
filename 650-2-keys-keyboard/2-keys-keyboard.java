class Solution {
    public int minSteps(int n) {
        if(n==1) return 0;
        if(n==2) return 2;

        return 1+minimumSteps(n, 1, 1);
    }
    public int minimumSteps(int n, int curLen, int prevLen) {
        if(curLen == n) {
            return 0;
        }
        if(curLen > n) return 1000;

        return Math.min(2+minimumSteps(n, curLen*2, curLen), 1+minimumSteps(n, curLen+prevLen, prevLen));
    }
}