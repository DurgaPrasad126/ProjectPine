class Solution {
    public int maxGoodNumber(int[] nums) {
        String[] binaryRep = new String[3];
        for(int i=0;i<3;i++) {
            binaryRep[i] = toBinary(nums[i]);
        }
        Arrays.sort(binaryRep, (a,b) -> (b+a).compareTo(a+b));
        //System.out.println(binaryRep[0] + " -- " + binaryRep[1] + " -- " + binaryRep[2]);
        return toInt(binaryRep);
    }

    public String toBinary(int num) {
        StringBuilder sb = new StringBuilder();
        while(num>0) {
            sb.append((char)(num%2+'0'));
            num/=2;
        }
        return sb.reverse().toString();
    }

    public int toInt(String[] binStr){
        String combined = binStr[0]+binStr[1]+binStr[2];
        int pow2 = 1;
        int res = 0;
        for(int i=combined.length()-1;i>=0;i--){
            res+=pow2*((int)(combined.charAt(i)-'0'));
            pow2*=2;
        }
        return res;
    }
}