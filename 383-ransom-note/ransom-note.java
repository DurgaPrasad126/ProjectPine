class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freqran = new int[26];

        for(int i=0;i<ransomNote.length();i++){
            freqran[(int)(ransomNote.charAt(i)-'a')]++;
        }

        for(int i=0;i<magazine.length();i++){
            freqran[(int)(magazine.charAt(i)-'a')]--;
        }


        for(int i=0;i<26;i++){
            if(freqran[i] > 0 ) return false;
        }
        return true;
    }
}