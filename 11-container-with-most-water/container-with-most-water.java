class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int low = 0;
        int high = n-1;
        while(low<high) {
            int minH = (Math.min(height[high], height[low]));
            int area = (high-low) * minH;
            while(low < high && height[low] <= minH) low++;
            while(low < high && height[high] <= minH) high--;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}