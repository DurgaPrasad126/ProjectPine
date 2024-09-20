class Solution {
    public long maximumPoints(int[] enEn, int currEn) {
        int minEn = Integer.MAX_VALUE;
        long sumEn = currEn;
        for(int en : enEn) {
            if(minEn > en) minEn = en;
            sumEn+=en;
        }
        if(currEn < minEn) return 0;
        sumEn-=minEn;
        return sumEn/minEn;
        /*
        int enemies = enEn.length;

        Arrays.sort(enEn);
        if(currEn < enEn[0]) return 0;
        long points = 0;
        int[] visited = new int[enemies];

        int unmarked = enemies-1;
        while(unmarked >= 0) {
            if(currEn < enEn[0] && points > 0) {
                currEn+=enEn[unmarked--];
            }
            else if(currEn >= enEn[0]) {
                points+=currEn/enEn[0];
                currEn%=enEn[0];
            }
        }
        return points;
        */
    }
}