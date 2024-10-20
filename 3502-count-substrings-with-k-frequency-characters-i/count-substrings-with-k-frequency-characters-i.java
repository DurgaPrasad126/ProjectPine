class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        char[] ch = s.toCharArray();
        int res = 0;
        int pos = 0;
        
            for(int j=0;j<n && pos<n;j++){
                freq[ch[j]-'a']++;
                while(isSatisfiedK(freq, k)) {
                    res+=(n-j);
                    freq[ch[pos++]-'a']--;
                }
            }
            
            

        return res;
    }
    public boolean isSatisfiedK(int[] freq, int k) {
        for(int i=0;i<26;i++){
            if(freq[i] >= k) return true;
        }
        return false;
    }
}