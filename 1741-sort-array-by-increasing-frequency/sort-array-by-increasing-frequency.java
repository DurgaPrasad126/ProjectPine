class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0)+1);
        }

        int[][] freqArr = new int[freqMap.size()][2];
        int pos = 0;
        for(Integer key : freqMap.keySet()){
            freqArr[pos][0] = key;
            freqArr[pos++][1] = freqMap.get(key);
        }

        Arrays.sort(freqArr, (a,b) -> a[1]!=b[1] ? a[1]-b[1] : (b[0]-a[0]));
        pos = 0; int lpos = 0;

        while(pos < freqArr.length){
            while(lpos<nums.length && freqArr[pos][1] > 0) {
                nums[lpos++]=freqArr[pos][0];
                freqArr[pos][1]--;
            }
            pos++;
        }
        return nums;
    }
}