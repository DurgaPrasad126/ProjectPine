class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();

        int ins = 0;
        int n = s.length();
        char[] ch = s.toCharArray();

        for(int i=0;i<n;i++){
            if(ch[i] == '(') st.push('(');
            else{
                if(i+1 < n && ch[i+1] == ')') i++;
                else ins++;

                if(!st.isEmpty()) st.pop();
                else ins++;
            }

        }
        if(!st.isEmpty()) ins+=(2*st.size());
        return ins;
    }
}