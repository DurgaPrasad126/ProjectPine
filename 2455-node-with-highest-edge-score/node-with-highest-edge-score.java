class Solution {
    public int edgeScore(int[] edges) {
        long[][] score = new long[edges.length][2];
        for(int i=0;i<edges.length;i++) {
            score[edges[i]][0]=1l*edges[i];
            score[edges[i]][1]+=0l+i;
        }
        

        Arrays.sort(score, (a,b) -> a[1]==b[1] ? Long.compare(a[0],b[0]) : Long.compare(b[1],a[1]));
        return (int)score[0][0];
    }
}