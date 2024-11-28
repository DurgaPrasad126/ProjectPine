class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();
        for(int i=0;i<n-1;i++){
            adjList.computeIfAbsent(i, l -> new HashSet<>()).add(i+1);
        }

        int[] res = new int[queries.length];
        int pos = 0;

        for(int[] query : queries) {
            adjList.get(query[0]).add(query[1]);
            res[pos++] = getShortestPath(adjList, n);
        }
        return res;
    }

    public int getShortestPath(Map<Integer, Set<Integer>> map, int n) {
        int min = Integer.MAX_VALUE;
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == 0 && map.get(cur[0]).contains(n-1)) return 1;
            for(int node : map.get(cur[0])) {
                if(node == n-1) {
                    min = Math.min(cur[1]+1, min);
                    return min;
                }
                if(!visited.contains(node)){
                    queue.add(new int[]{node, cur[1]+1});
                    visited.add(node);
                }
            }
        }
        return -1;
    }
}