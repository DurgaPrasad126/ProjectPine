class Solution {
    public int minOperations(String[] logs) {
        int minOperations = 0;
        for(int i=0;i<logs.length;i++) {
            if(logs[i].equals("./")) continue;
            else if(logs[i].equals("../")) {
                minOperations--;
                if(minOperations < 0) minOperations = 0;
            }
            else minOperations++;
        }
        return minOperations > 0 ? minOperations : 0;
    }
}