class Solution {
    public int possibleStringCount(String word) {
        
        char[] ch = word.toCharArray();
        int n = ch.length;
        int ans =1;
        int j=1,count=0;

        while(j<n){
            if(ch[j]==ch[j-1]){
                count++;
            }else{
                ans += count;
                count=0;
            }
            j++;
        }
        ans += count;
        return ans;
    }
}