class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();

        int n = ch.length;
        int unb = 0;

        for(int i=0;i<n;i++) {
            if(ch[i] == '[') {
                st.push('[');
            }
            else {
                if(!st.isEmpty()) {
                    if(st.peek() == '[') st.pop();
                    else unb++;
                }
                else unb++;
            }
        }

        return (unb+1)/2;
    }
}