class Solution {
    public String reverseParentheses(String s) {
        Stack<String> message = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder();
                while(!message.isEmpty()  && !message.peek().equals("(")) {
                    //System.out.println(message.peek());
                    sb.append(message.pop());
                }
                message.pop();
                message.push(sb.reverse().toString());
            }
            else {
                message.push(String.valueOf(s.charAt(i)));
            }
        }

        StringBuilder res = new StringBuilder();
    while(!message.isEmpty()) {
        res.append(message.pop());
    }

    return res.reverse().toString();
    }

    
}