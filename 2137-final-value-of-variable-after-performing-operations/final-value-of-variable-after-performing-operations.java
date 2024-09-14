class Solution {
    public int finalValueAfterOperations(String[] o) {
        int val = 0;
        for(String i : o) {
            val += (i.charAt(0) == '+' || i.charAt(2) == '+') ? 1 : (-1);
        }
        return val;
    }
}