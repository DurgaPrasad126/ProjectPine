class Solution {
    public int similarPairs(String[] words) {
        int wordsLen = words.length;
        boolean[][] ap = new boolean[wordsLen][26];

        for(int j=0;j<wordsLen;j++) {
            for(int i=0;i<words[j].length();i++) {
                ap[j][words[j].charAt(i)-'a'] = true;
            }
        }

        int similarStrings = 0;
        for(int i=0;i<wordsLen;i++){
            for(int j=i+1;j<wordsLen;j++){
                int count = 0;
                for(int k=0;k<26;k++){
                    if(ap[i][k] == ap[j][k]) count++;
                }
                if(count == 26) similarStrings++;
            }
        }
        return similarStrings;
    }
}