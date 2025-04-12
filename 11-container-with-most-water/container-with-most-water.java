class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int low = 0;
        int high = n-1;
        while(low<high) {
            int area = (high-low) * (Math.min(height[high], height[low]));
            if(height[low] > height[high]) high--;
            else low++;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}