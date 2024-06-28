class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] edgeCount = new int[n+1];

        for(int i=0;i<n;i++){
            edgeCount[edges[i][0]-1]++;
            edgeCount[edges[i][1]-1]++;
        }

        for(int i=0;i<n+1;i++){
            if(edgeCount[i] == n) return i+1;
        }
        return 0;
    }
}