class Solution {
    Map<String, Integer> res = new TreeMap<>();
    Stack<Integer> stack = new Stack<>();
    int multiplier = 1;
    
    public String countOfAtoms(String formula) {
        int i = formula.length() - 1;
        
        while (i >= 0) {
            if (formula.charAt(i) == '(') {
                multiplier /= stack.pop();
                i--;
                continue;
            }
            
            int end = i;
            int val = 1;
            
            if (Character.isDigit(formula.charAt(i))) {
                while (Character.isDigit(formula.charAt(i))) i--;
                val = Integer.parseInt(formula.substring(i+1, end+1));
            } 

            end = i;
            if (Character.isLetter(formula.charAt(i))) {
                while(Character.isLowerCase(formula.charAt(i))) i--;
                String key = formula.substring(i, end+1);
                res.put(key, multiplier*val + res.getOrDefault(key, 0));
            } else {  // case ')'
                multiplier *= val;
                stack.push(val);
            }
            i--;
        }
        
        StringBuilder rs = new StringBuilder();
        for (Map.Entry<String, Integer> entry : res.entrySet()) {
            rs.append(entry.getKey());
            if (entry.getValue() > 1) rs.append(entry.getValue());
        }
        
        return rs.toString();
    }
}