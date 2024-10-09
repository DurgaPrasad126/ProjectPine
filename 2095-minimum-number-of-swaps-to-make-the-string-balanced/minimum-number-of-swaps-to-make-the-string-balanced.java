class Solution {
    public int minSwaps(String s) {
        int open = 0;
        int n = s.length();

        for(int i=0;i<n;i++) {
            if(s.charAt(i) == '[') {
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