class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        int open = 0;
        int close = 0;

        for(int i=0;i<ch.length;i++){
            /*if(!stack.isEmpty() && ch[i] == ')' && stack.peek() == '(') {
                stack.pop();
            }
            else stack.push(ch[i]); */
            if(ch[i] == '(') {
                open++;
            }
            else if(ch[i] == ')') {
                if(open > 0) open--;
                else close++;
            }

        }
        return open+close;//stack.size();
    }
}