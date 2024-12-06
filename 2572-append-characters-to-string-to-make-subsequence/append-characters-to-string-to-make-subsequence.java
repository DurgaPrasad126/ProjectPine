class Solution {
    public int appendCharacters(String s, String t) {
        int poss = 0, post = 0;
        int lens = s.length(), lent = t.length();
        int minCount = 0;

        while(poss < lens && post < lent) {
            while(poss < lens && s.charAt(poss) != t.charAt(post)) poss++;
            if(poss < lens && post < lent && s.charAt(poss) == t.charAt(post)) {
                poss++;
                post++;
            }
        }
        return post == lent ? 0 : lent - post;
    }
}