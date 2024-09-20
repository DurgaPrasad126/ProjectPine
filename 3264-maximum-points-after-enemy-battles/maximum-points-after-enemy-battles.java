class Solution {
    public long maximumPoints(int[] enEn, int currEn) {
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
    }
}