class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        long pairs = 0;

        int[] rem = new int[60];

        for(int i=0;i<time.length;i++){
            rem[time[i]%60]++;
        }

        for(int i=0;i<=30;i++){
            //System.out.println(i+ " --- " + rem[i]);
            if(i==0 || i==30) pairs+=(1l*(rem[i])*(rem[i]-1))/(1l*2);
            else pairs+=(1l*(rem[i]*rem[60-i]));
        }

        return (int)pairs;   
    }
}