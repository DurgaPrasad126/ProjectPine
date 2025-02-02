class Solution {
    public boolean check(int[] nums) {
        int dipIdx = -1;
        int n = nums.length;
        int[] doubleNum = new int[2*n];
        int i=0;
        while(i < n-1 && nums[i] <= nums[i+1]) {
            i++;
        }
        i++;
        for(int j=0;j<n;j++) {
            doubleNum[j] = nums[j];
            doubleNum[j+n] = nums[j];
        }

        for(int j=i;j<n+i-1;j++){
            if(doubleNum[j] > doubleNum[j+1]) return false;
        }


        return true;


    }
}