class Solution {
    public static boolean[] primes = getPrimeNumbers(100000);
    public int smallestValue(int n) {
        if(n<=4) return n;
        while(!primes[n]) {
            int sum = 0;
            int num = n;

            for(int i=2;i<=num;i++){
                if(primes[i] && num%i==0) {
                    while(num%i==0) {
                        sum+=(i);
                        num/=i;
                    }
                }
            }
            n=sum;
        }
        return n;
    }
    public static boolean[] getPrimeNumbers(int n){
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for(int i=2;i*i<=n;i++){
            if(prime[i]){
                for(int j=i*i;j<=n;j+=i){
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}