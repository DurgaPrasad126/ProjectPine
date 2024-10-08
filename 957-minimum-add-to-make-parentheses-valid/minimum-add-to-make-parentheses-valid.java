class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();

        for(int i=0;i<ch.length;i++){
            if(!stack.isEmpty() && ch[i] == ')' && stack.peek() == '(') {
                stack.pop();
            }
            else stack.push(ch[i]);
        }
        return stack.size();
    }
}