class Solution {
    public int edgeScore(int[] edges) {
        long[] score = new long[edges.length];
        for(int i=0;i<edges.length;i++) {
            score[edges[i]]+=0l+i;
        }
        int maxIndex = 0;
        for(int i=0;i<score.length;i++){
            if(score[i] > score[maxIndex]) maxIndex = i;
        }
        //Arrays.sort(score, (a,b) -> a[1]==b[1] ? Long.compare(a[0],b[0]) : Long.compare(b[1],a[1]));
        return maxIndex;
    }
}