class Solution {
    public char repeatedCharacter(String s) {
        int[] count = new int[26];
        int[] sec = new int[26];
        char[] c = s.toCharArray();
        for(int i=0;i<s.length();i++) {
            if(count[c[i]-'a'] == 1) sec[c[i]-'a'] = i;
            count[c[i]-'a']++;
        }

        int repeat = Integer.MAX_VALUE;

        for(int i=0;i<26;i++){
            if(count[i] >= 2) repeat = Math.min(repeat, sec[i]);
        }
        return c[repeat];
    }
}