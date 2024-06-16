class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer,Integer> freq = new TreeMap<>();
        for(int i : power) freq.put(i,freq.getOrDefault(i,0)+1);
        int n = freq.size();
        long[][] dp = new long[n][3];
        int pos =0;
        for(int i : freq.keySet()){
            dp[pos][0] = i;
            dp[pos][1] = freq.get(i);
            pos++;
        }
        dp[0][2] = 1l*dp[0][0]*dp[0][1];
        for(int i =1;i<n;i++){
            long add = 1l*dp[i][0]*dp[i][1];
            long max = Long.MIN_VALUE;
            for(int j=1;j<=3 && i-j>=0;j++){
                if(dp[i-j][0]==dp[i][0]-1 || dp[i-j][0]==dp[i][0]-2){
                    max = Math.max(dp[i-j][2],max);
                }else{
                    max = Math.max(dp[i-j][2]+add,max);
                    break;
                }
            }
            dp[i][2] = Math.max(max,add);
        }
        return dp[n-1][2];
    }
}