class Solution {
    public String largestNumber(int[] nums) {
        List<String> numStr = new ArrayList<>();
        for(int num : nums) {
            numStr.add(String.valueOf(num));
        }
        Collections.sort(numStr, (a,b) -> (b+a).compareTo(a+b));
        if(numStr.get(0).equals("0")) return "0";
        StringBuilder largeNum = new StringBuilder();
        for(String s : numStr) largeNum.append(s);
        return largeNum.toString();        
    }
}