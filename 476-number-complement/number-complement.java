class Solution {
    public int findComplement(int num) {
        
        int cur =1;
        int ans =0;

        while(num>0){
            if((num&1)==0) ans+= cur;
            num = num>>1;
            cur = cur<<1;
        }
        return ans;
    }
}