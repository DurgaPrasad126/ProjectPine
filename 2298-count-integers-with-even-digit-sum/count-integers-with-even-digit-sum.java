class Solution {
    public int countEven(int num) {
        int digit=num,sum=0;
            while(digit>0){
                sum+=digit%10;
                digit/=10;
            }
        return sum%2==0?num/2:(num-1)/2;
    }
}