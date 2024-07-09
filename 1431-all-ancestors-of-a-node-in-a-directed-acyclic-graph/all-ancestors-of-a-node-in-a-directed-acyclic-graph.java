class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];

        for(int[] edge : edges) {
            map.computeIfAbsent(edge[0], l -> new ArrayList<>()).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++) {
            if(indegree[i] == 0) q.add(i);
        }

        List<Set<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++) res.add(new HashSet<>());

        while(!q.isEmpty()) {
            int currNode = q.poll();
            
            if(map.get(currNode) == null) continue;
            for(int i: map.get(currNode)) {
                indegree[i]--;
                if(indegree[i] == 0) q.add(i);
                res.get(i).add(currNode);
                res.get(i).addAll(res.get(currNode));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++) ans.add(new ArrayList<Integer>());

        for (int i = 0; i < n; i++) {
            for (int node = 0; node < n; node++) {
                if (node == i) continue;
                if (res.get(i).contains(node)) {
                    ans.get(i).add(node);
                }
            }
        }

        return ans;
    }
}