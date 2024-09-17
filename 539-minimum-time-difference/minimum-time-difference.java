class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int minDiff = Integer.MAX_VALUE;
        for(int i=1;i<timePoints.size();i++) {
            int min1 = Integer.valueOf(timePoints.get(i-1).substring(0,2)) * 60 + Integer.valueOf(timePoints.get(i-1).substring(3));
            int min2 = Integer.valueOf(timePoints.get(i).substring(0,2)) * 60 + Integer.valueOf(timePoints.get(i).substring(3));

            if(min2-min1 < minDiff) minDiff = min2-min1;
        }
        int min2 = Integer.valueOf(timePoints.get(timePoints.size()-1).substring(0,2)) * 60 + Integer.valueOf(timePoints.get(timePoints.size()-1).substring(3));
        int min1 = Integer.valueOf(timePoints.get(0).substring(0,2)) * 60 + Integer.valueOf(timePoints.get(0).substring(3));

        return Math.min(minDiff, 1440-(min2-min1));
    }
}