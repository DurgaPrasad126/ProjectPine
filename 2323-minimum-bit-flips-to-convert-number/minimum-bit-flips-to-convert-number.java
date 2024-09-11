class Solution {
    public int minBitFlips(int start, int goal) {
        int num = start^goal;
        int count = 0;
        while(num > 0) {
            count+=(num%2);
            num/=2;
        }
        return count;
    }
}