class Solution {
    int[] parent;
    long[] size;
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        size = new long[n];

        for(int i=0;i<n;i++) parent[i]=i;
        Arrays.fill(size, 1);

        for(int[] edge : edges) {
            int leftParent = find(edge[0]);
            int rightParent = find(edge[1]);
            
            if(leftParent == rightParent) continue;

            if(size[leftParent] >= size[rightParent]) {
                parent[rightParent] = leftParent;
                size[leftParent]+=size[rightParent];
            }
            else {
                parent[leftParent] = rightParent;
                size[rightParent]+=size[leftParent];
            }
        }

        long unreachableNodes = (long)(1l*n*(n-1)/2);

        for(int i=0;i<n;i++) {
            if(parent[i] == i) {
                long elements = size[i];
                unreachableNodes-=(1l*elements*(elements-1)/2);
            }
        }

        return unreachableNodes;
        
    }

    private int find(int index) {
        if(parent[index] != index) parent[index] = find(parent[index]);
        return parent[index];
    }
}