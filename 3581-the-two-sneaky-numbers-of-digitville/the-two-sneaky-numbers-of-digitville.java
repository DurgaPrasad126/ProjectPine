class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] freq = new int[101];
        int[] result = new int[2];
        for(int num: nums) {
            if(freq[num] == 1) {
                if(result[0] == 0) result[0] = num;
                else result[1] = num;
            }
            freq[num]++;
        }
        return result;
    }
}