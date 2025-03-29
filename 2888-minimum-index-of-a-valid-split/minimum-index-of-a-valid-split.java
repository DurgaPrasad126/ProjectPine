class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int maxCount = 0;
        int domEle = -1;

        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if(count.get(num) > maxCount) {
                maxCount = count.get(num);
                domEle = num;
            }
        }

        int domEleCount = 0;
        int n = nums.size();
        for(int i=0;i<n;i++) {
            if(nums.get(i) == domEle) {
                domEleCount++;
            }
            if(domEleCount * 2 > (i+1) && (maxCount-domEleCount) * 2 > (n-1-i)) {
                return i;
            }
        }
        return -1;
    }
}