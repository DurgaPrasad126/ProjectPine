class Solution {
    public int findTheCity(int n, int[][] edges, int t) {
        long[][] dist = new long[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for(int i=0;i<edges.length;i++) {
            dist[edges[i][0]][edges[i][1]] = edges[i][2];
            dist[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                if(i==j) {
                    dist[i][j]=0;
                    break;
                }
            }
        }


        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        int minCity = -1;
        int minCost = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int cost = 0;
            for(int j=0;j<n;j++){
                if(dist[i][j] <= t) cost++;
            }
            if(minCost >= cost) {
                minCost = cost;
                minCity = i;
            }
        }
        return minCity;
    }
}