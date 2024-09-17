class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] s1split = s1.split(" ");
        String[] s2split = s2.split(" ");

        Map<String, Integer> freq = new HashMap<>();

        for(String s : s1split) freq.put(s, freq.getOrDefault(s,0) + 1);
        for(String s : s2split) freq.put(s, freq.getOrDefault(s,0) + 1);

        int size = 0;
        for(String key : freq.keySet()) {
            if(freq.get(key) == 1) size++;
        }

        String[] res = new String[size];
        size-=1;
        for(String key : freq.keySet()) {
            if(freq.get(key) == 1) res[size--] = key;
        }
        return res;
    }
}