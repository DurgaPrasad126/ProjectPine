class Solution {
    public int possibleStringCount(String word) {
        int left = 0;
        int right = 0;
        int n = word.length();
        int res = 1;
        char[] ch = word.toCharArray();

        while(right<n) {
            while(right < n && ch[left] == ch[right]) {
                right++;
            }
            res+=(right-left-1);
            left=right;
        }
        return res;
    }
}