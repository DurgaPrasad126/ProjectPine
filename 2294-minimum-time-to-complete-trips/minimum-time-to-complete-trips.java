class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 0;
        long high = 100000000000000l;
        long res = 100000000000000l;

        while(low<high) {
            long mid = low +(high-low)/2l;
            long totalTripsPossbile = calculateTotalTripsPossible(time, mid);
            //System.out.println(mid + " --- " + totalTripsPossbile);
            if(totalTripsPossbile >= totalTrips) {
                res=mid;
                high=mid;
            }
            else {
                low = mid+1;
            }
        }

        return res;
    }

    public long calculateTotalTripsPossible(int[] time, long maxTime) {
        long trips = 0;
        for(int t : time) {
            trips+=(maxTime/t);
        }
        return trips;
    }
}