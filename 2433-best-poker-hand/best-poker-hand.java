class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int[] rankfreq = new int[14];
        int[] suitsfreq = new int[4];

        for(int i=0;i<ranks.length;i++){
            rankfreq[ranks[i]]++;
            suitsfreq[suits[i]-'a']++;
        }

        for(int i=0;i<suitsfreq.length;i++){
            if(suitsfreq[i] == 5) return "Flush";
            
        }
        int max = 0;
        for(int i=0;i<rankfreq.length;i++){
            max = Math.max(max, rankfreq[i]);
        }

        return max >= 3 ? "Three of a Kind" : (max == 2) ? "Pair" : "High Card";
    }
}