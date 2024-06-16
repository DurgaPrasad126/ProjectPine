class Solution {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> countPairs = new HashMap<>();
        int n = hours.length;
        for(int i=0;i<n;i++) {
            countPairs.put(hours[i]%24, countPairs.getOrDefault(hours[i]%24, 0) + 1);
        }
        long completePairs = 0l;
        int[] counted = new int[24];
        for(Integer rem : countPairs.keySet()) {
            if(rem == 0 || rem == 12) {
                counted[rem]=1;
                int number = countPairs.get(rem);
                completePairs+=(long)number*(number-1)/2;
            }
            else {
                int remainingRemainder = 24-rem;
                if(countPairs.containsKey(remainingRemainder)) {
                    if(counted[rem] == 1 || counted[remainingRemainder] == 1) continue;
                    int remSize = countPairs.get(rem);
                    int remainingRemainderSize = countPairs.get(remainingRemainder);
                    completePairs+=(long)remSize*remainingRemainderSize;
                    counted[rem] = 1;
                    counted[remainingRemainder] = 1;
                }
            }
        }
        return completePairs;
    }
}