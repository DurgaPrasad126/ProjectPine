class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        while(sb.length() < k) {
            int pos = 0;
            StringBuilder sb1 = new StringBuilder();
            while(pos < sb.length()) {
                sb1.append(sb.charAt(pos) == 'z' ? 'a' : (char)(sb.charAt(pos++)+1));
            }
            sb.append(sb1);
        }
        return sb.charAt(k-1);
    }
}