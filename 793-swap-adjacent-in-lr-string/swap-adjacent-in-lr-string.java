class Solution {
    public boolean canTransform(String start, String target) {
          //return true;
        int poss = 0;
        int post = 0;

        int lens = start.length();
        int lent = target.length();

        while(poss < lens && post < lent) {
            while(poss < lens && start.charAt(poss) == 'X') {
                poss++;
            }
            while(post < lent && target.charAt(post) == 'X') {
                post++;
            }
            if(poss < lens && post < lent){
                if((poss > post && start.charAt(poss) == 'R') 
                    || (poss < post && start.charAt(poss) == 'L') 
                    || start.charAt(poss++) != target.charAt(post++)) return false;
            }
        }

        while(poss < lens) {
            if(start.charAt(poss++) != 'X') return false;
        }
        while(post < lent) {
            if(target.charAt(post++) != 'X') return false;
        }
        return true;
    }
}