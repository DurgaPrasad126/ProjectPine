class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1000000007;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(Integer.toBinaryString(i));
        }

        int concatInt = 0;
        int pow2 = 1; 
        for(char c : sb.reverse().toString().toCharArray()) {
            concatInt = (concatInt%MOD) + ((pow2%MOD)*((int)(c-'0'))%MOD);
            pow2=(pow2%MOD)*2;
            concatInt%=MOD;
        }
        return (int)concatInt;
    }
}