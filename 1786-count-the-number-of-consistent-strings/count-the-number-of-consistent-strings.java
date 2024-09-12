class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int baseString = 0;
        for(int i=0;i<allowed.length();i++) baseString|=1<<(allowed.charAt(i)-'a');
        int consistentStrings = 0;
        for(String word: words) {
            if(isStringConsistent(word, baseString)) consistentStrings++;
        }
        return consistentStrings;
    }

    public boolean isStringConsistent(String word, int baseString) {
        for(char ch : word.toCharArray()) {
            if(((baseString >> (ch-'a')) & 1) != 1) return false;
        }
        return true;
    }
}