class Solution {
    public int getLucky(String s, int k) {
        int sum = 0;
        char[] ch = s.toCharArray();

        for(char c : ch) {
            int val = (int)(c-'a')+1;
            sum+=val/10+val%10;
        }
        k--;
        while(k>0) {
            int transform = sum;
            sum=0;
            while(transform>0) {
                sum+=transform%10;
                transform/=10;
            }
            k--;
        }
        
        return sum;
    }
}