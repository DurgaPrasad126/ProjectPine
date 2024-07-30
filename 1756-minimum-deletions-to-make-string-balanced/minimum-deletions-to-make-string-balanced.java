class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();

        int minDelete = 0;
        //char[] ch = s.toCharArray();

        for(int i=0;i<s.length();i++) {
            if(!stack.isEmpty() && stack.peek() == 'b' && s.charAt(i) == 'a') {
                minDelete++; 
                stack.pop();
            }
            else stack.push(s.charAt(i));
        }

        return minDelete;
    }
}