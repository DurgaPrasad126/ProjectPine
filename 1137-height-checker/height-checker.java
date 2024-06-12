class Solution {
    public int heightChecker(int[] heights) {
        int[] heightReplica = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);

        int diffInHeight = 0;

        for(int i=0;i<heights.length;i++){
            if(heightReplica[i] != heights[i]) diffInHeight++;
        }
        return diffInHeight;
    }
}