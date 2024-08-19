class Solution {
    public int minSteps(int n) {
        if(n==1) return 0;
        if(n==2) return 2;

        return 1+minimumSteps(n, 0, 1,1);
    }
    public int minimumSteps(int n, int steps, int aCount, int curCount) {
        if(n == curCount) return steps;
        if(n < curCount) return 1000;

        return Math.min(minimumSteps(n, steps+1, aCount, curCount+aCount), minimumSteps(n, steps+2, curCount, 2*curCount));
    }
}