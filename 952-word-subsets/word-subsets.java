class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] bFreq = new int[26];
        int[] temp;
        for(int i=0;i<words2.length;i++){
            temp = new int[26];
            for(char ch : words2[i].toCharArray()) {
                temp[ch-'a']++;
            }
            for(int j=0;j<26;j++) {
                if(temp[j] > bFreq[j]) bFreq[j] = temp[j];
            }
        }
        
        List<String> universalStrings = new ArrayList<>();
        
        boolean notUni;
        for(String word  : words1) {
            notUni = false;
            temp = new int[26];
            for(char ch : word.toCharArray()) temp[ch-'a']++;

            for(int i=0;i<26;i++) {
                if(temp[i] < bFreq[i]) {
                    notUni = true;
                    break;
                }
            }
            if(!notUni) {
                universalStrings.add(word);
            }
        }
        return universalStrings;
    }
}