class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] noOfFlights = new int[n];

        for(int i=0;i<bookings.length;i++){
            noOfFlights[bookings[i][0]-1] += bookings[i][2];
            if(bookings[i][1] != n) noOfFlights[bookings[i][1]] -= bookings[i][2];
        }

        for(int i=1;i<n;i++){
            noOfFlights[i]+=noOfFlights[i-1];
        }

        return noOfFlights;

    }
}