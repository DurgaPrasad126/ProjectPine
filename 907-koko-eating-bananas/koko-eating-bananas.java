class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length == 1) {
            return piles[0]%h == 0? piles[0]/h : piles[0]/h + 1;
        }
        int max = 0; int min = 1;
        for(int pile : piles) {
            if(max < pile) max = pile;
        }
        int low = min;
        int high = max;
        int res = 0;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(isPossible(piles, mid, h)) {
                res = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return res;
    }

    private boolean isPossible(int[] piles, int mid, int h) {
        int hours = 0;
        for(int pile : piles) {
            if(hours >= h) return false;
            hours+= (pile%mid == 0) ? (pile/mid) : (pile/mid) + 1;
        }
        return hours <= h;
    }
}