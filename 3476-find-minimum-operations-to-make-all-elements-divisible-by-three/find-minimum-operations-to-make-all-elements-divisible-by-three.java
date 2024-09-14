class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        for(int num : nums) {
            operations += (num%3 == 0 ? 0 : 1);
        }
        return operations;
    }
}