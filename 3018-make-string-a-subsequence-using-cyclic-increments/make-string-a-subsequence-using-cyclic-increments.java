class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str2.length() > str1.length()) return false;
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int len1 = ch1.length;
        int len2 = ch2.length;
        for(int i=0;i<len1;i++) {
            if(ch1[i] == 'z') ch1[i] = 'a';
            else ch1[i] = (char)(ch1[i]+1);
        }
        //System.out.println(new String(ch1));

        int pos2 = 0, pos1 = 0;
        while(pos2 < len2 && pos1 < len1) {
            if(ch1[pos1] == ch2[pos2] || getPreviousChar(ch1[pos1]) == ch2[pos2]) {
                pos2++;
            }
            pos1++;
        }
        return pos2 == len2;
    }
    public char getPreviousChar(char ch){
        return ch == 'a' ? 'z' : (char) (ch-1);
    }
}