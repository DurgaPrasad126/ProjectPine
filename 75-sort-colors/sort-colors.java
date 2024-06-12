class Solution {
    public void sortColors(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int i=0;
        for(Integer key : map.keySet()) {
            int count = map.get(key);
            while(count > 0) {
                nums[i++] = key;
                count--;
            }
        }
    }
}