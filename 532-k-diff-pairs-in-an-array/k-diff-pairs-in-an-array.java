class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int uniquePairs = 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        for(int key : map.keySet()) {
            if(k==0) uniquePairs+=(map.get(key)>1 ? 1 : 0);
            else{
                if(map.containsKey(key+k)) uniquePairs++;
            }
        }
        return uniquePairs;
    }
}