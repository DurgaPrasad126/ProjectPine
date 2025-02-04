class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        Map<Integer, Integer> map = new HashMap<>();
        int vowelStrCount = 0;
        for(int i=0;i<words.length;i++) {
            char[] word = words[i].toCharArray();
           
            if(vowels.contains(word[0]) 
                && vowels.contains(word[word.length-1])) {
                    vowelStrCount++;
                    map.put(i, vowelStrCount);
                }
            else {
                map.put(i, vowelStrCount);
            }
        }

        int[] count = new int[queries.length];
        int pos = 0;

        for(int[] query : queries) {
            count[pos++] = map.get(query[1]) - (query[0] != 0 ? map.get(query[0]-1) : 0);
        }
        return count;
    }
}