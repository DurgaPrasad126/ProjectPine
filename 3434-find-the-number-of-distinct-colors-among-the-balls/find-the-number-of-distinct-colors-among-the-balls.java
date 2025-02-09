class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>();
        int[] res = new int[queries.length];
        int pos = 0;
        for(int[] query : queries) {
            if(map.containsKey(query[0])) {
                int curColor = map.get(query[0]);
                color.put(curColor, color.getOrDefault(curColor, 0)-1);
                if(color.get(curColor) == 0) color.remove(curColor);
                map.put(query[0], query[1]);
                color.put(query[1],color.getOrDefault(query[1], 0)+1);
                res[pos++] = color.size();
            }
            else {
                map.put(query[0], query[1]);
                color.put(query[1], color.getOrDefault(query[1], 0)+1);
                res[pos++] = color.size();
            }
        }
        return res;
    }
}