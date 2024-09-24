class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();
        for(int arr : arr1) {
            while(!prefixes.contains(arr) && arr > 0) {
                prefixes.add(arr);
                arr/=10;
            }

        }

        int maxLength = 0;

        for(int arr : arr2) {
            while(!prefixes.contains(arr) && arr > 0) {
                arr/=10;
            }
            if(arr > 0) {
                maxLength = Math.max(maxLength, (int)Math.log10(arr) + 1);
            }
        }
        return maxLength;
    }
}