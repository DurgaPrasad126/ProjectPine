class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] freq = new int[101];
        for(int i: nums) freq[i]++;
        int[] res = new int[2];
        for(int i : freq) {
            res[0]+=(i/2);
            res[1]+=(i%2);
        }
        return res;
    }
}