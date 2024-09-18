class Solution {
    public String largestNumber(int[] nums) {
        List<String> numStr = new ArrayList<>();
        for(int num : nums) {
            numStr.add(String.valueOf(num));
        }
        Collections.sort(numStr, (a,b) -> (b+a).compareTo(a+b));
        StringBuilder largeNum = new StringBuilder();
        for(String s : numStr) largeNum.append(s);
        int pos = 0;
        String largStr = largeNum.toString();
        int len = largStr.length();
        while(pos < len && largStr.charAt(pos) == '0') pos++;
        return pos == len ? "0" : largStr.substring(pos);        
    }
}