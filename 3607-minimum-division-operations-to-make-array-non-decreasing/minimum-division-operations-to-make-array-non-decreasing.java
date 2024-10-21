class Solution {
    public static int[] properDiv = getProperDivisors(1000000);
    public int minOperations(int[] nums) {
        int minOp = 0;
        int n = nums.length;

        for(int i = n-2; i>=0;i--){
            while(nums[i] > nums[i+1]) {
                if(properDiv[nums[i]] == 1 && nums[i] > nums[i+1]) return -1;
                nums[i]/=properDiv[nums[i]];
                minOp++;
            }

        }

        return minOp;
    }
    public static int[] getProperDivisors(int n) {
        int[] div = new int[n+1];
        Arrays.fill(div,1);
        for(int i=2;i*2<=n;i++){
            for(int j=2*i;j<=n;j+=i){
                div[j]=i;
            }
        }
        return div;
    }
}