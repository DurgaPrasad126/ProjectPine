class Solution {
    public int minIncrementForUnique(int[] nums) {
        //Arrays.sort(nums);
        nums = countSort(nums);
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

    private int[] countSort(int[] nums) {
        int n = nums.length;
        int MAX = Integer.MIN_VALUE;
        for(int nu : nums) if(MAX < nu) MAX = nu;
        int[] result = new int[MAX+1];

        for(int i=0;i<n;i++) {
            result[nums[i]]++;
        }

        int pos = 0;
        for(int i=0;i<MAX+1;i++) {
            while(result[i] > 0) {
                nums[pos++] = i;
                result[i]--;
            }
        }
        return nums;
    }
}