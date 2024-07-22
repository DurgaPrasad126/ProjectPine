class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        char[] ch = s.toCharArray();
        int n = s.length();

        int vowelCount = 0;
        for(char c : ch) {
            if(vowels.contains(c)) vowelCount++;
        }
        
        if(vowelCount == 0) return false;
        //if(vowelCount % 2 == 1) return true;

        return true;
    }
}