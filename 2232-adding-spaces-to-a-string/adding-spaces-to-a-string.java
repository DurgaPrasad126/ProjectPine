class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder res = new StringBuilder();
        int pos = 0;
        int spos = 0;
        int len = s.length();
        int slen = spaces.length;

        while(pos < len && spos < slen) {
            if(spaces[spos] == 0) {
                res.append(" ");
                spos++;
                continue;
            }
            if(pos == spaces[spos]-1) {
                res.append(s.charAt(pos++) + " ");
                spos++;
            }
            else res.append(s.charAt(pos++));
        }
        while(pos < len) res.append(s.charAt(pos++));
        return res.toString();
    }
}