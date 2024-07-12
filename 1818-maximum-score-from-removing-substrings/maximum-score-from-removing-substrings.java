class Solution {
    public int maximumGain(String s, int x, int y) {
        String[] sarr = {s};
        int maxPointsGained = 0;
        if(x>y) {
            maxPointsGained+=calculatePoints(sarr, x, "ab");
            maxPointsGained+=calculatePoints(sarr, y, "ba");
        } else{        
            maxPointsGained+=calculatePoints(sarr, y, "ba");
            maxPointsGained+=calculatePoints(sarr, x, "ab");
        }
        return maxPointsGained;
    }

    public int calculatePoints(String[] s, int p, String query){
        int totalPoints = 0;
        /*while(s[0].indexOf(query) != -1) {
            int index = s[0].indexOf(query);
            s[0] = s[0].substring(0, index)+s[0].substring(index+2);
            totalPoints+=p;
        }*/

        Stack<Character> stack = new Stack<>();
        char[] ch = s[0].toCharArray();
        for(int i=0;i<ch.length;i++){
            if(!stack.isEmpty() && stack.peek() == query.charAt(0) 
                                && ch[i] == query.charAt(1)) {
                                    stack.pop();
                                    totalPoints+=p;
            }
            else{
                stack.push(ch[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        s[0] = sb.reverse().toString();
        return totalPoints;
    }
}