class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = Long.MAX_VALUE;
        long high = 1;
        //long res = 1;

        for(int t : time) {
            low = Math.min(low, t);
            //high  = Math.max(high, t);
        }
        high = (long)low*totalTrips;
        //high=res;

        while(low<high) {
            long mid = low +(high-low)/2l;
            long totalTripsPossbile = calculateTotalTripsPossible(time, mid);
            if(totalTripsPossbile >= totalTrips) {
                //res=mid;
                high=mid;
            }
            else {
                low = mid+1;
            }
        }

        return low;
    }

    public long calculateTotalTripsPossible(int[] time, long maxTime) {
        long trips = 0;
        for(int t : time) {
            trips+=(maxTime/t);
        }
        return trips;
    }
}