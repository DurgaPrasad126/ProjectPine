class Solution {
    public int minimumOperations(int[] nums) {
        int[] freq = new int[101];
        boolean unique = true;
        int size = nums.length, pos = 0, minOperations = 0;
        for(int num : nums) {
            if(unique && freq[num] == 1) unique = false;
            freq[num]++;
        }
        if(unique) return 0;

        while(pos < size) {
            if(size-pos < 3) break;
            freq[nums[pos++]]--;
            freq[nums[pos++]]--;
            freq[nums[pos++]]--;
            minOperations++;

            if(isUnique(freq)) return minOperations;
        }
        return minOperations+1;
    }

    public boolean isUnique(int[] freq) {
        for(int f : freq) if(f > 1) return false;
        return true;
    }
}