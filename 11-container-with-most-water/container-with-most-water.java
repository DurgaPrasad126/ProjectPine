class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length-1;

        while(l < r) {
            int min = Math.min(height[l],height[r]);
            maxArea = Math.max(maxArea, min*(r-l));
            while(height[l] <= min && l < r) l++;
            while(height[r] <= min && l < r) r--;
        }
        return maxArea;
    }
}