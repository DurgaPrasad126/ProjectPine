class Solution {
    public int minSwaps(int[] nums) {
        int oneCount  = 0;
        int n = nums.length;
        for(int num : nums) if(num == 1) oneCount++;
        int minSwaps = Integer.MAX_VALUE;
        int[] circNums = new int[2*n];
        for(int i=0;i<n;i++){
            circNums[i] = circNums[n+i] = nums[i];  
        }

        for(int i=0;i<2*n;i++) System.out.print(circNums[i] + " --- ");

        int count = 0;
        for(int i=0;i<oneCount;i++) if(circNums[i] == 1) count++;
        if(count == oneCount) return 0;
        for(int i=1;i<circNums.length-oneCount;i++){
            count+=(-(circNums[i-1]==1 ? 1: 0) + (circNums[oneCount+i-1]==1 ? 1:0));
            if(count == oneCount) return 0;

            minSwaps = Math.min(Math.abs(oneCount-count), minSwaps);
        }
        return minSwaps;
    }
}