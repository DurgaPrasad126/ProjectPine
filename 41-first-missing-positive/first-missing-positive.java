class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] space = new int[100001];
        for(int i : nums) {
            if(i> 0 && i<= nums.length) space[i] = 1;
        }

        for(int i=1;i<space.length;i++){
            if(space[i] == 0) return i;
        }
        return 100001;
    }
}