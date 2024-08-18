class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> uglyNumbers = new TreeSet<>();
        uglyNumbers.add(1L);
        Long curUgly = 1L;
        for(int i=0;i<n;i++){
            curUgly = uglyNumbers.pollFirst();

            uglyNumbers.add(curUgly*2);
            uglyNumbers.add(curUgly*3);
            uglyNumbers.add(curUgly*5);
        }
        return curUgly.intValue();
    }

    
}