class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();

        Map<Character, Integer> index = new HashMap<>();

        int pos = 0, curLen = 0, maxLen = Integer.MIN_VALUE;
        while(pos < n) {
            if(index.containsKey(ch[pos])) {
                maxLen = Math.max(curLen, maxLen);
                curLen = 0;
                pos = index.get(ch[pos])+1;
                //Arrays.fill(index, -1);
                index.clear();
            }
            curLen++;
            index.put(ch[pos], pos);
            pos++;
        }
        return Math.max(maxLen, curLen);
    }
}