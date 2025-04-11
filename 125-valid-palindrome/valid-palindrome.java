class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int low = 0;
        int high = s.length()-1;
        while(low < high) {
            if(s.charAt(low) == ' ' || !Character.isLetterOrDigit(s.charAt(low))) low++;
            else if(s.charAt(high) == ' ' || !Character.isLetterOrDigit(s.charAt(high))) high--;
            else if(s.charAt(low) != s.charAt(high)) return false;
            else {
                low++;
                high--;
            }
        }
        return true;
    }
}