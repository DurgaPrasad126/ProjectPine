class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == x) nums[count++] = i;
        }
        int n = queries.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            if(queries[i] <= count) {
                res[i] = nums[queries[i]-1];
            }
            else res[i] = -1;
        }
        return res;
    }
}