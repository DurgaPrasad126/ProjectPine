class Solution {
    public int largestCombination(int[] candidates) {
        int len = 0;
        int maxLen = 0;
        for(int j=0;j<24;j++){
            len  = 0;
            for(int i=0;i<candidates.length;i++){
                len+=(candidates[i]%2) & 1;
                candidates[i]/=2;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}