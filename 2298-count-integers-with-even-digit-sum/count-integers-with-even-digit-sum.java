class Solution {
    public int countEven(int num) {
        int count = 0, sum=0, digit=0;
        for(int i=1; i<= num;i++) {
            sum =0;
            digit=i;
            while(digit>0){
                sum+=digit%10;
                digit/=10;
            }
            if(sum%2==0) count++;
        }
        return count;
    }
}