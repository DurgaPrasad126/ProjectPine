class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int completePairs = 0;
        int n = hours.length;

        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++){
                long hrs = (long)hours[i]+(long)hours[j];
                if(hrs%(long)24 == 0) completePairs++;
            }
        }
        return completePairs;
    }
}