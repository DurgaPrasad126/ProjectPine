class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums) {
            if(max < num) max = num;
            if(min > num) min = num;
        }
        return gcd(max, min);
    }
    public int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b, a%b);
    }
}