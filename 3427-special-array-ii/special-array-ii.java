class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int len = nums.length;
        int[] sameParityCount = new int[len];
        for(int i=1;i<len;i++){
            sameParityCount[i] = sameParityCount[i-1] + (nums[i-1] % 2 == nums[i] % 2 ? 1 : 0);
            //System.out.print(sameParityCount[i] + " -- ");
        }



        boolean[] result = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            if(sameParityCount[queries[i][0]] == sameParityCount[queries[i][1]]) result[i] = true;
            else result[i] = false;
        }
        return result;
    }
}