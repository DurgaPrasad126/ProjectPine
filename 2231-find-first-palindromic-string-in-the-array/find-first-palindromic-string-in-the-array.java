class Solution {
    public String firstPalindrome(String[] words) {
        for(int i=0;i<words.length;i++){
            
            if(isPalindrome(words[i])) return words[i];
        }
        return "";
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        //char[] ch = s.toCharArray();

        for(int i=0, j=n-1;i<j;i++,j--) {
            if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}