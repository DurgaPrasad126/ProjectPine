class Solution {
    public int minChanges(int n, int k) {
        if(n < k) return -1;
        int count = 0;
        while(n > 0) {
            int nbit = (n) & 1;
            int kbit= (k) & 1;

            System.out.print(nbit + " --- nb --- ");

            System.out.print(kbit + " --- kb --- ");


            if(nbit == 1 && kbit != 1) count++;
            else if(nbit == 0 && kbit != nbit) return -1;
            
            n=n>>1;
            k=k>>1;

            System.out.print(n + " --- n --- ");

            System.out.print(k + " --- k --- ");
            System.out.println();

        }
        return count;
    }
}