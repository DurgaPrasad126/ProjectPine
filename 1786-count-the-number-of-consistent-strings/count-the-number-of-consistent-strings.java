class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] baseString = new int[26];
        for(int i=0;i<allowed.length();i++) baseString[allowed.charAt(i)-'a']++;
        int consistentStrings = 0;
        for(String word: words) {
            if(isStringConsistent(word, baseString)) consistentStrings++;
        }
        return consistentStrings;
    }

    public boolean isStringConsistent(String word, int[] baseString) {
        for(char ch : word.toCharArray()) {
            if(baseString[ch-'a'] == 0) return false;
        }
        return true;
    }
}