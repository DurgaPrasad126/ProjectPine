class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int maxLoc = Integer.MIN_VALUE;

        for(int[] trip : trips) maxLoc = Math.max(maxLoc, trip[2]);

        int[] cumuCap = new int[maxLoc + 2];

        for(int i=0; i<n; i++){
            cumuCap[trips[i][1]] += trips[i][0];
            if(trips[i][2] < maxLoc) cumuCap[trips[i][2]] -= trips[i][0];
        }

        for(int i=0;i<=maxLoc;i++){

            if(i!=0) cumuCap[i]+=cumuCap[i-1];
            //System.out.print(cumuCap[i] + " --- ");
            if(cumuCap[i] > capacity) return false;
        }
        return true;
    }
}