class Solution {
    public int[] findOrder(int n, int[][] p) {
        Map<Integer, List<Integer>> coursePrereq = new HashMap<>();
        Queue<Integer> courseOrder = new LinkedList<>();
        int[] indegree = new int[n];

        //construct the graph with adjacency list
        // prereq -> courses
        for(int i=0;i<p.length;i++) {
            coursePrereq.computeIfAbsent(p[i][1], k -> new ArrayList<Integer>()).add(p[i][0]);
            indegree[p[i][0]]++;
        }

        //add the nodes with indegree 0 to the queue
        for(int i=0;i<n;i++) {
            if(indegree[i] == 0) courseOrder.offer(i);
        }

        List<Integer> allCourses = new ArrayList<>();

        //topological sort
        while(courseOrder.size() > 0) {
            int course = courseOrder.poll();
            allCourses.add(course);
            if(coursePrereq.get(course) != null) {
                for(int prereq : coursePrereq.get(course)) {
                    indegree[prereq]--;
                    if(indegree[prereq] == 0) courseOrder.offer(prereq);
                }
            }

        }

        int[] res = new int[allCourses.size()];
        for(int i=0;i<allCourses.size();i++) {
            res[i] = allCourses.get(i);
        }
        return res.length == n ? res : new int[0];
    }
}