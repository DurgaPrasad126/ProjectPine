class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        char[] ch = s.toCharArray();
        int n = ch.length;

        int[] close = new int[n+1];
        for(int i=n-1;i>=0;i--) {
            if(ch[i] == ')') {
                close[i] = close[i+1]+1;
            }
            else close[i] = close[i+1];
        }

        for(int i=0;i<ch.length;i++){
            if(ch[i] == '(') {
                if(close[i] > open) {
                    sb.append(ch[i]);
                }
                open++;
            }
            else if(ch[i] == ')') {
                if(open > 0) {
                    open--;
                    sb.append(ch[i]);
                }
            }
            else {
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }
}