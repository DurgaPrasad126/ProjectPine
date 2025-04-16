class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        Map<Integer, Integer> countToIdx = new HashMap<>();
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == x) countToIdx.put(++count, i);
        }
        int n = queries.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            if(countToIdx.containsKey(queries[i])) {
                res[i] = countToIdx.get(queries[i]);
            }
            else res[i] = -1;
        }
        return res;
    }
}