class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();

        int minDelete = 0;
        char[] ch = s.toCharArray();

        for(char c : ch) {
            if(!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                minDelete++; 
                stack.pop();
            }
            else stack.push(c);
        }

        return minDelete;
    }
}