class Solution {
    public String stringHash(String s, int k) {
        int n = s.length();
        int[] digPrefix = new int[n];

        digPrefix[0]  = s.charAt(0)-97;
        for(int i=1;i<n;i++){
            digPrefix[i] = digPrefix[i-1] + (s.charAt(i)-97);
        }

        for(int i : digPrefix) System.out.println(i + " --- ");

        StringBuilder sb = new StringBuilder();
        int pos=0;
        while(pos<n) {
            int prevSum = 0;
            if(pos!=0) prevSum = digPrefix[pos-1];
            
            sb.append((char)(97+(digPrefix[pos+k-1]-prevSum)%26));
            pos+=k;
        }

        return sb.toString();
    }
}