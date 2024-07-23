class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        char[] ch = s.toCharArray();

        for(char c : ch) freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        System.out.println(freqMap);
        String[][] freqArr = new String[freqMap.size()][2];
        int pos = 0;
        for(char key : freqMap.keySet()) {
            freqArr[pos][0] = String.valueOf(key);
            freqArr[pos++][1] = String.valueOf(freqMap.get(key));
        }
        Arrays.sort(freqArr, (a,b) -> Integer.valueOf(b[1])-Integer.valueOf(a[1]));
        StringBuilder res = new StringBuilder();
        pos = 0;
        while(pos < freqArr.length){
            int val = Integer.valueOf(freqArr[pos][1]);
            while(val > 0) {
                res.append(freqArr[pos][0]);
                val--;
            }
            pos++;
        }
        return res.toString();
    }
}