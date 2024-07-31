class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        char[] ch = blocks.toCharArray();

        int minRec = 0, minK = 0;

        for(int i=0;i<k;i++) {
            minRec+=(ch[i] == 'W') ? 1 : 0;
        }
        minK = minRec;

        for(int i=1;i<=n-k;i++){
            minK+=(ch[i-1] == 'W' ? -1 : 0)+(ch[i+k-1] == 'W' ? 1 : 0);
            minRec = Math.min(minK, minRec);
        }
        return minRec;
    }
}