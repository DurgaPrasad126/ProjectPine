class Solution {
    public int minElement(int[] nums) {
        int minEle = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++) {
            int digSum = digitSum(nums[i]);
            if(minEle > digSum) {
                minEle = digSum;
            }
        }
        return minEle;
    }
    public int digitSum(int num) {
        int sum = 0;
        while(num > 0) {
            sum+=(num%10);
            num/=10;
        }
        return sum;
    }
}