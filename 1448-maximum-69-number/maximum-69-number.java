class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        if(s.indexOf('6') != -1 ) {
            int idx = s.indexOf('6');
            s = s.substring(0, idx) + '9' + s.substring(idx+1);
        }
        return Integer.valueOf(s);
    }
}