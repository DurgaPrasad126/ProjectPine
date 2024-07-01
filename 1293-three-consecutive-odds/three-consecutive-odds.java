class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int consecutiveOddCount = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2 == 0 && consecutiveOddCount > 0) consecutiveOddCount = 0;
            else consecutiveOddCount++;

            if(consecutiveOddCount == 3) return true;
        }
        return false;
    }
}