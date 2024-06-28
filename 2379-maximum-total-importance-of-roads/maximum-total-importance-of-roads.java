class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] edgeCount = new int[n];
        for(int i=0;i<roads.length;i++) {
            edgeCount[roads[i][0]]++;
            edgeCount[roads[i][1]]++;
        }
        

        long ans = 0;
        Arrays.sort(edgeCount);
        for(int i=0;i<n;i++) {
            
            ans+=1l*edgeCount[i]*(i+1);
        }
        return ans;
    }
}