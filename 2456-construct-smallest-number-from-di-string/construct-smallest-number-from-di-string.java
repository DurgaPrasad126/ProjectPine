class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        int[] sInt = new int[n+1];
        sInt[0]=1;
        for(int i=1;i<=n;i++) sInt[i]=sInt[i-1]+1;

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){
            if(pattern.charAt(i) == 'D') {
                if(stack.isEmpty() || (!stack.isEmpty() && stack.peek() != sInt[i])) stack.push(sInt[i]);
                stack.push(sInt[i+1]);
            }
            else{
                if(stack.isEmpty()) sb.append((char)(48+sInt[i]));
                while(!stack.isEmpty()) {
                    sb.append((char)(48+stack.pop()));
                }
            }
        }
        if(stack.isEmpty()) sb.append((char)(48+sInt[n]));
        while(!stack.isEmpty()) sb.append((char)(48+stack.pop()));
        return sb.toString();
    }
}