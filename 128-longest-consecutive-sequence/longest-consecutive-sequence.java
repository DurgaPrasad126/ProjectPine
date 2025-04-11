class Solution {
    public int longestConsecutive(int[] nums) {
        int longCons = 0;
        Set<Integer> ele = new HashSet<>();
        for(int num : nums) ele.add(num);
        for(int num : ele) {
            if(!ele.contains(num-1)) {
                int curLong = 1;
                int curEle = num;
                while(ele.contains(curEle+1)) {
                    curLong++;
                    curEle+=1;
                }
                longCons = Math.max(longCons, curLong);
            }
        }
        return longCons;
    }
}