class Solution {
    public static boolean[] primes = getPrimeNumbers(1000);
    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> primeNumbers = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(primes[num]) primeNumbers.add(num);
            for(int j=2;j*j<=num;j++){

                if(primes[j] && num%j == 0) {
                    primeNumbers.add(j);
                    while(num%j == 0) {
                        num/=j;
                    }
                    if(primes[num]) primeNumbers.add(num);
                    if(num < 2) break;
                }
            }
        
        }
        return primeNumbers.size();
    }
    public static boolean[] getPrimeNumbers(int n) {
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for(int i=2;i*i<=n;i++){
            if(primes[i]) {
                for(int j=i*i;j<=n;j+=i) {
                    primes[j] = false;
                }
            }
        }
        return primes;
    }
}