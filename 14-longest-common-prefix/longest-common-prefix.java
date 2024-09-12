class Solution {
    public String longestCommonPrefix(String[] strs) {
        String longestPrefix = strs[0];
        int prefixLen = longestPrefix.length();

        for(String str : strs) {
            while(str.indexOf(longestPrefix) != 0) {
                longestPrefix = longestPrefix.substring(0, prefixLen-1);
                prefixLen--;
            }
        }
        return longestPrefix;
    }
}