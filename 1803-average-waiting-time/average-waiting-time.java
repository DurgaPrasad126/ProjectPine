class Solution {
    public double averageWaitingTime(int[][] customers) {
        long timeTillNow = customers[0][0]+customers[0][1];
        long totalWaitTime = timeTillNow - customers[0][0];
        int n = customers.length;

        for(int i=1;i<n;i++) {
            if(timeTillNow >= customers[i][0]) {
                totalWaitTime+=timeTillNow+customers[i][1]-customers[i][0];
                timeTillNow+=customers[i][1];
            }
            else {
                totalWaitTime+= customers[i][1];
                timeTillNow = customers[i][0]+customers[i][1];
            }
        }
        return (double)(1d*totalWaitTime)/n;
    }
}