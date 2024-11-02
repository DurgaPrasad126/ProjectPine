class Solution {
    public String makeFancyString(String s) {
        int curFreq=0;
        char curChar = ' ';
        int i = 0;
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();
        while(i<s.length()) {
            if(ch[i] == curChar) {
                if(curFreq < 2) {
                    sb.append(ch[i]);
                    curFreq++;
                }
            }
            else {
                sb.append(ch[i]);
                curChar = ch[i];
                curFreq=1;
            }
            i++;
        }
        return sb.toString();
    }
}