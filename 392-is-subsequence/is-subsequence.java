class Solution {
    public boolean isSubsequence(String s, String t) {
        int poss = 0;
        int post = 0;
        int lens = s.length();
        int lent = t.length();

        while(poss < lens && post < lent) {
            if(s.charAt(poss) == t.charAt(post)) {
                poss++;
            }
            post++;
        }
        return poss == lens;
    }
}