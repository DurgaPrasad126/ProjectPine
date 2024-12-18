class Solution {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int left = 0;
        int right = 1;

        for(int i=0;i<len-1;i++){
            int j=i+1;
            while(j< len && prices[j] > prices[i]) j++;
            if(j == len) continue;
            else prices[i]-=prices[j];
        }
        return prices;
    }
}