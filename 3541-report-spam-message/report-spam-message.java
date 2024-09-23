class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Map<String, Integer> banned = new HashMap<>();
        constructBannedMap(bannedWords, banned);

        return isSpam(message, banned);
    }

    public void constructBannedMap(String[] bannedWords, Map<String, Integer> banned) {
        for(String word : bannedWords) banned.put(word, banned.getOrDefault(word, 0)+1);
    }

    public boolean isSpam(String[] message, Map<String, Integer> banned) {
        int matchedWords = 0;
        for(String word : message) {
            if(banned.containsKey(word)) {
                if(matchedWords == 1) return true;
                else {
                    matchedWords++;
                }
            }
        }
        return false;
    }
}