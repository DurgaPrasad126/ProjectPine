class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        int minMoves = 0;

        int n = nums.length;
        for(int i=0;i<n;i++) {
            if(stack.isEmpty() || stack.peek() < nums[i]) stack.push(nums[i]);
            else {
                minMoves+=1+stack.peek()-nums[i];
                stack.push(stack.peek()+1);
            }
        }
        return minMoves;
    }
}