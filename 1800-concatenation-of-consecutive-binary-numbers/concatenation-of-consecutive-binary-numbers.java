class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1000000007;
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(Integer.toBinaryString(i));
        }

        int concatInt = 0;
        int pow2 = 1;
        //String binStr = sb.reverse().toString();
        char[] ch = sb.toString().toCharArray();
        for(int i = ch.length-1;i>=0;i--) {
            concatInt += ((pow2)*((int)(ch[i]-'0'))%MOD);
            pow2=(pow2%MOD)*2;
            concatInt%=MOD;
        }
        return concatInt;
    }
}