class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int n = s.length();

        for(char c : s.toCharArray()) {
            if(c == '[') {
                open++;
            }
            else {
                if(open > 0) {
                    open--;
                }
            }
        }
        return (open+1)/2;
    }
}