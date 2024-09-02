class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int i : chalk) sum+=i;

        sum = 1l*k%sum;

        for(int i=0;i<chalk.length;i++){
            if(sum < chalk[i]) return i;
            else {
                sum-=chalk[i];
            }
        }
        return -1;
    }
}