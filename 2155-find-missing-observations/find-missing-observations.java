class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int rollsSum  = 0;

        for(int i: rolls) rollsSum+=i;

        int remSum = (mean*(m+n))-rollsSum;

        if(remSum < n || remSum > n*6) return new int[0];

        int[] nArr = new int[n];
        Arrays.fill(nArr, 1);
        remSum-=n;

        int pos = 0;
        while(remSum > 0) {
            if(remSum > 5) {
                nArr[pos]+=5;
                remSum-=5;
            }
            else {
                nArr[pos]+=remSum;
                remSum = 0;
            }
            pos++;
        }
        return nArr;
    }
}