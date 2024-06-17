class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int res = 1;
        int idx = 0;

        while(idx < coins.length && res >= coins[idx]) {
            res+=coins[idx];
            idx++;
        }
        return res;
    }
}