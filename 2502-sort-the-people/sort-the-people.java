class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        String[] res  = new String[heights.length];
        for(int i=0;i<heights.length;i++) {
            map.put(heights[i], names[i]);
        }
        int i=0;
        for(String name: map.values()) res[i++] = name;
        return res;
    }
}