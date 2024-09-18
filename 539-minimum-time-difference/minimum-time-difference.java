class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();

        int[] freq = new int[1440];

        for(int i=0;i<n;i++) {
            int minutes = Integer.valueOf(timePoints.get(i).substring(0,2))*60+Integer.valueOf(timePoints.get(i).substring(3));
            if(freq[minutes] == 1) return 0;
            freq[minutes]++;
        }
        int prevIdx = Integer.MAX_VALUE;
        int firstIdx = Integer.MAX_VALUE;
        int lastIdx = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        for(int i=0;i<1440;i++){
            if(freq[i] == 1) {
                if(prevIdx != Integer.MAX_VALUE) minDiff = Math.min(minDiff, i-prevIdx);
                prevIdx = i;
                if(firstIdx == Integer.MAX_VALUE) firstIdx = i;
                lastIdx = i;
            }
        }

        return Math.min(minDiff, 1440 - lastIdx + firstIdx);
    }
}