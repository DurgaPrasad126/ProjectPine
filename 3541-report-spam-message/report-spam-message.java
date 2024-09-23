class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> banned = new HashSet<>();
        constructBannedMap(bannedWords, banned);

        return isSpam(message, banned);
    }

    public void constructBannedMap(String[] bannedWords, Set<String> banned) {
        for(String word : bannedWords) banned.add(word);
    }

    public boolean isSpam(String[] message, Set<String> banned) {
        int matchedWords = 0;
        for(String word : message) {
            if(banned.contains(word)) {
                if(matchedWords == 1) return true;
                else {
                    matchedWords++;
                }
            }
        }
        return false;
    }
}