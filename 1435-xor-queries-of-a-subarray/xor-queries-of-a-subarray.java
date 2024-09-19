class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] prefixSum = calculatePrefixXor(arr);
       
        int[] res = new int[n];
        for(int i=0;i<n;i++) {
            res[i] = prefixSum[queries[i][1]]^(queries[i][0]== 0 ? 0 : (prefixSum[queries[i][0]-1]));
        }
        return res;
    }

    public int[] calculatePrefixXor(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i=1;i<n;i++) {
           prefix[i]=arr[i]^prefix[i-1];
        }
        return prefix;
    }
}