class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> subArrCount = new HashMap<>();
        int n = s.length();
       // for(int i=minSize;i<=maxSize;i++) {
            for(int j=0;j<=n-minSize;j++) {
                String sub = s.substring(j, j+minSize);
                if(subArrCount.containsKey(sub)) {
                    subArrCount.put(sub, subArrCount.get(sub) + 1);
                    continue;
                }
                if(isValid(sub, maxLetters)) {
                    subArrCount.put(sub, subArrCount.getOrDefault(sub, 0) + 1);
                }
            }
        //}
        int maxOcc = 0;
        for(String key : subArrCount.keySet()) {
            maxOcc = Math.max(maxOcc, subArrCount.get(key));
        }
        return maxOcc;
    }
    public boolean isValid(String s, int maxL) {
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()) {
            set.add(c);
        }
        return set.size() <= maxL;
    }
}