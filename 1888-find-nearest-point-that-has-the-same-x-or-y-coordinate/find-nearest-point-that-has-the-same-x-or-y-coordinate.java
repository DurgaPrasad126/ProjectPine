class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int nearestIndex = -1;

        for(int i=0;i<points.length;i++){
            if(points[i][0] == x || points[i][1] == y) {
                if(nearestIndex == -1 || distance(points, i, x, y) < distance(points, nearestIndex, x, y)) {
                    nearestIndex = i;
                }
            }
        }
        return nearestIndex;
    }

    public int distance(int[][] points, int index, int x, int y) {
        return Math.abs(x-points[index][0]) + Math.abs(y-points[index][1]);
    }
}