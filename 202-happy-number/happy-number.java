class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while( n > 1) {
            int num = n;
            int sum = 0;
            while(num > 0) {
                int rem = num%10;
                sum+=(rem*rem);
                num/=10;
            }
            if(seen.contains(sum)) return false;
            n=sum;
            seen.add(sum);
        }

        return n==1;
    }
}