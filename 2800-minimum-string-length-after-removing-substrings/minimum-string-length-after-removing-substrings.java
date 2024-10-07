class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        for(int i=0;i<s.length();i++){

            if(!stack.isEmpty()) {
                if((stack.peek() == 'A' && ch[i] == 'B') 
                    || (stack.peek() == 'C' && ch[i] == 'D')) {
                    stack.pop();
                }
                else {
                    stack.push(ch[i]);
                }
            } else {
                stack.push(ch[i]);
            }
        }

        return stack.size();
    }
}