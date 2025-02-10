class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();
        boolean isNumberPresent = false;
        for(char c : s.toCharArray()) {
            if(isNumber(c)) {
                isNumberPresent = true;
                if(!stack.isEmpty()) stack.pop();
            }
            else {
                stack.push(c);
            }
        }

        if(!isNumberPresent) return s;
        StringBuilder res = new StringBuilder();

        while(!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }

    public boolean isNumber(char c) {
        return ((int)(c-'0')) >= 0 && ((int)(c-'0')<=9);
    }
}