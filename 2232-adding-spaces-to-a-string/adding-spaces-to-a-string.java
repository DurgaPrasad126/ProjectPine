class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        int pos = 0;
        int spos = 0;
        int len = s.length();
        int slen = spaces.length;
        char[] ch = s.toCharArray();
        if(spaces[spos] == 0) {
                res.append(" ");
                spos++;
            }
        while(pos < len && spos < slen) {
            
            if(pos == spaces[spos]-1) {
                res.append(ch[pos++] + " ");
                spos++;
            }
            else res.append(ch[pos++]);
        }
        res.append(s.substring(pos));
        return res.toString();
    }
}