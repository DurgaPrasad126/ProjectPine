class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        int minArrows = 0;

        int targetEnd = Integer.MAX_VALUE;
        int targetStart = Integer.MIN_VALUE;

        for(int[] point : points) {
            System.out.println(point[0] + " -- " + point[1]);
            if(point[0] <= targetEnd) {
                targetEnd = Math.min(point[1], targetEnd);
                targetStart = Math.max(point[0], targetStart);
                System.out.println(targetEnd);
            }
            else {
                minArrows++;
                targetStart = point[0];
                targetEnd = point[1];
            }
        }
        return minArrows+1;
    }
}