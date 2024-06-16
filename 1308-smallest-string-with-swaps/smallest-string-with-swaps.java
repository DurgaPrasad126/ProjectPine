class Solution {
    int[] parent;
    int[] size;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        parent = new int[n];
        size = new int[n];
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for(int i=0;i<n;i++) parent[i] = i;
        Arrays.fill(size, 1);
        for(List<Integer> pair : pairs) {
            int leftParent = find(pair.get(0));
            int rightParent = find(pair.get(1));

            if(size[leftParent] >= size[rightParent]) {
                parent[rightParent] = leftParent;
                size[leftParent]+=size[rightParent];
            }
            else if(size[leftParent] < size[rightParent]) {
                parent[leftParent] = rightParent;
                size[rightParent]+=size[leftParent];
            }
        }

        for(int i=0;i<s.length();i++) {
            int rootParent = find(i);
            map.computeIfAbsent(rootParent, l -> new PriorityQueue<>()).add(s.charAt(i));
        }
        System.out.println(map);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            int rootParent = find(i);
            if(!map.containsKey(rootParent)) continue;
            sb.append(map.get(rootParent).poll());
        }
        return sb.toString();
        
    }

    public int find(int index) {
        if(parent[index] != index) parent[index] = find(parent[index]);
        return parent[index];
    }
}