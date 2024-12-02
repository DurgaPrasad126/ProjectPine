class Solution {
    public int prefixCount(String[] words, String pref) {
       // String[] words = sentence.split(" ");
        int count=0;
        for(int i=0;i<words.length;i++){
            if(words[i].startsWith(pref)) count++;
        }
        return count;
    }
}