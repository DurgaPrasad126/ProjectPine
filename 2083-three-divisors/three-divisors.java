class Solution {
    public boolean isThree(int n) {
        int sqrt = (int)Math.sqrt(n);
        if(sqrt*sqrt != n) return false;
        return isPrime(sqrt);
    }
    public boolean isPrime(int num) {
        if(num<2) return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}