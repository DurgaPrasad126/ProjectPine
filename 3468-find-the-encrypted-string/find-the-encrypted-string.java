class Solution {
    public String getEncryptedString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();
        for(int i=0;i<s.length();i++){
            sb.append(str[(i+k)%s.length()]);
        }
        return sb.toString();
    }
}