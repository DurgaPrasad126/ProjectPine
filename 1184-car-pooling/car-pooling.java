class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] travel = new int[1002];
        for(int i=0;i<trips.length;i++) {
            travel[trips[i][1]] += trips[i][0];
            travel[trips[i][2]] -= trips[i][0];
        }

        for(int i=0;i<travel.length;i++) {
            if(i!=0) travel[i]+=travel[i-1];
             if(capacity < travel[i]) return false;
        }

        return true;
    }
}