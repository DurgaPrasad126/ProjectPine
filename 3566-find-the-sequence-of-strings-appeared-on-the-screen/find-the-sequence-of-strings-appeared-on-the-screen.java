class Solution {
    public List<String> stringSequence(String target) {
        List<String> res = new ArrayList<>();
        int pos = 0;

        StringBuilder sb = new StringBuilder();
        sb.append('a');
        for(char ch : target.toCharArray()) {
            int n = sb.length();
            while(n <= target.length() && sb.charAt(n-1) != ch) {
                res.add(sb.toString());
                sb.setCharAt(n-1, (char)(sb.charAt(n-1)+1));
            }
            res.add(sb.toString());
            sb.append('a');
        }
        return res;
    }
}