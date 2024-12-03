class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        int pos = 0;
        int spos = 0;
        int len = s.length();
        int slen = spaces.length;
        char[] ch = s.toCharArray();

        while(pos < len && spos < slen) {
            if(spaces[spos] == 0) {
                res.append(" ");
                spos++;
                continue;
            }
            if(pos == spaces[spos]-1) {
                res.append(ch[pos++] + " ");
                spos++;
            }
            else res.append(ch[pos++]);
        }
        while(pos < len) res.append(ch[pos++]);
        return res.toString();
    }
}