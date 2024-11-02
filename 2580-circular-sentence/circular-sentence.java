class Solution {
    public boolean isCircularSentence(String sentence) {
        if(sentence.charAt(0) != sentence.charAt(sentence.length()-1)) return false;
        String[] strings = sentence.split(" ");

        if(strings.length == 1) {
            return strings[0].charAt(0) == strings[0].charAt(strings[0].length()-1);
        }

        for(int i=1;i<strings.length;i++){
            if(strings[i].charAt(0) != strings[i-1].charAt(strings[i-1].length()-1)) return false;
        }
        return true;
    }
}