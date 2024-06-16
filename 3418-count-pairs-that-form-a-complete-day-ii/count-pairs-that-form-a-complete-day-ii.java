class Solution {
    public long countCompleteDayPairs(int[] hours) {
        int[] counted = new int[24];
        int n = hours.length;
        for(int i=0;i<n;i++) {
            counted[hours[i]%24]++;
        }
        long completePairs = 0l;

        for(int i =0;i<=12;i++){
            if(i == 0 || i == 12) {
                completePairs += (1l*(counted[i])*(counted[i]-1))/2;
            }else{
                completePairs += 1l*(counted[i])*(counted[24-i]);
            }
        }
        return completePairs;
    }
}