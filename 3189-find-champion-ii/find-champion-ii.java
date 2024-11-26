class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] isWeaker = new int[n];
        int result = -1;
        for(int[] edge : edges){
            isWeaker[edge[1]]++;
        }
        for(int i = 0;i<n;i++){
            if(isWeaker[i] == 0 && result != -1) return -1;
            else if(isWeaker[i] == 0) result = i;
        }
        return result;
    }

}
