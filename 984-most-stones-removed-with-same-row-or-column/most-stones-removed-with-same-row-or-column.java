class Solution {
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet<>();
        int count = 0;
        for(int[] stone : stones) {
            if(!visited.contains(stone)) {
                dfs(stone, visited,  stones);
                count++;
            }
        }
        return stones.length-count;
    }
    public void dfs(int[] stone, Set<int[]> visited, int[][] stones) {
        visited.add(stone);
        for(int[] s : stones) {
            if(!visited.contains(s)) {
                if(s[0] == stone[0] || s[1] == stone[1]) dfs(s, visited, stones);
            }
        }
    }
}