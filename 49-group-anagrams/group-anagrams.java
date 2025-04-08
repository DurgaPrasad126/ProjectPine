class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsGroup = new HashMap<>();

        for(String str : strs) {
            String freqStr = getFrequencyString(str);
            anagramsGroup.computeIfAbsent(freqStr, l -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramsGroup.values());
    }

    public String getFrequencyString(String str) {
        int[] freq = new int[26];
        for(int i=0;i<str.length();i++) {
            freq[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++) {
            sb.append((char)(48+freq[i]));
        }
        return sb.toString();
    }
}