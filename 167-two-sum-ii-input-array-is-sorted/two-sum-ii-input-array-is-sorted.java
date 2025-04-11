class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int n = numbers.length;
        for(int i=0;i<n-1;i++) {
            int secNum = target-numbers[i];
            int secNumIdx = secondNumberFound(numbers, i+1, secNum, n-1);
            if(secNumIdx != -1) return new int[]{i+1, secNumIdx+1};
        }
        return new int[0];
    }
    public int secondNumberFound(int[] numbers, int low, int secNum, int high) {
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(numbers[mid] == secNum) return mid;
            if(numbers[mid] > secNum) {
                high=mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
    }
}