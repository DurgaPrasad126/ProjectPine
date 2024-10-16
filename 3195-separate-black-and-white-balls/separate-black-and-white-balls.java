class Solution {
    public long minimumSteps(String s) {
        int len = s.length();
        int left = 0;
        int right = len-1;
        char[] ch = s.toCharArray();
        long minSwaps = 0;

        while(left < right) {
            while(left < right && ch[right] == '1') {
                right--;
            }
            if(ch[left] == '1' && ch[right]=='0') {
                minSwaps+=(right-left);
                right--;
            }
            left++;
        }
        return minSwaps;
    }
}