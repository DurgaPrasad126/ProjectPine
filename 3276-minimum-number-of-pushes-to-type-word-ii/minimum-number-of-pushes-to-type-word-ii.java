class Solution {
    public int minimumPushes(String word) {
        if(word.length() == 1) return 1;

        int[] freq = new int[26];
        int count = 0;
        char[] ch = word.toCharArray();
        for(int i=0;i<ch.length;i++){
            freq[(int)(ch[i]-'a')]++;
        }
        Arrays.sort(freq);

        for(int i=25;i>=0;i--){
            count+=(1+(25-i)/8)*freq[i];
        }
        return count;
    }
}