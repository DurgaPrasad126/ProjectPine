class Solution {
    public int minimumLength(String s) {
        if(s.length() < 3) return s.length();
        char[] ch = s.toCharArray();
        int[] freq = new int[26];
        for(char c : ch) {
            freq[c-'a']++;
        }
        int count = 0;
        for(int i : freq) {
            if(i==0) continue;
            else if(i%2 == 0) count+=2;
            else count+=1;
        }
        return count;
    }
}