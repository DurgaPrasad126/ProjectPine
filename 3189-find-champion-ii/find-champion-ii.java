class Solution {
    int[] isWeaker = new int[100];
    public int findChampion(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = constructAdjList(edges);
        System.out.println(adjList);
        if(n-adjList.size() > 1) return -1;

        for(int i=0;i<n;i++) {
            if(isWeaker[i] == 0) return i;
        }
        return -1;
    }

    public Map<Integer, List<Integer>> constructAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges) {
            adjList.computeIfAbsent(edge[1], l -> new ArrayList<>()).add(edge[0]);
            isWeaker[edge[1]] = 1;
        }
        return adjList;
    }
}