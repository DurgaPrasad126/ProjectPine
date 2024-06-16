class Solution {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, List<Integer>> countPairs = new HashMap<>();
        int n = hours.length;
        for(int i=0;i<n;i++) {
            countPairs.computeIfAbsent(hours[i]%24, l->new ArrayList<>()).add(hours[i]);
        }
        System.out.println(countPairs);
        long completePairs = 0l;
        int[] counted = new int[24];
        for(Integer rem : countPairs.keySet()) {
            if(rem == 0 || rem == 12) {
                counted[rem]=1;
                int number = countPairs.get(rem).size();
                completePairs+=(long)number*(number-1)/2;
            }
            else {
                int remainingRemainder = 24-rem;
                if(countPairs.containsKey(remainingRemainder)) {
                    if(counted[rem] == 1 || counted[remainingRemainder] == 1) continue;
                    int remSize = countPairs.get(rem).size();
                    int remainingRemainderSize = countPairs.get(remainingRemainder).size();
                    completePairs+=(long)remSize*remainingRemainderSize;
                    counted[rem] = 1;
                    counted[remainingRemainder] = 1;
                }
            }
        }
        return completePairs;
    }
}