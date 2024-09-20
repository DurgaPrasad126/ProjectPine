class Solution {
    public int bestClosingTime(String customers) {
       int curPen = 0;
       for(char c : customers.toCharArray()) if(c == 'Y') curPen++;

       int minPen = curPen;
       int earliestHour = 0;

       for(int i=0;i<customers.length();i++) {
            char c = customers.charAt(i);
            if(c == 'Y') curPen--;
            else curPen++;

            if(minPen > curPen) {
                minPen = curPen;
                earliestHour = i+1;
            }
       }
       return earliestHour;
    }
}