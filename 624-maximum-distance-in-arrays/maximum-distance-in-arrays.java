class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDist = 0;
        /*PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        List<Integer> array = new ArrayList<>();
        int len = 0;
        for(int i=0;i<arrays.size();i++){
            array = arrays.get(i);
            len = array.size();
            maxHeap.add(new int[]{i, array.get(len-1)});
            minHeap.add(new int[]{i, array.get(0)});
        }
        //System.out.println(maxHeap);
        //System.out.println(minHeap);

        int[] max = maxHeap.poll();
        int[] min = minHeap.poll();

        if(max[0] == min[0]) {
            if(Math.abs(max[1]-minHeap.peek()[1]) < Math.abs(min[1]-maxHeap.peek()[1])){
                max = maxHeap.poll();
            }
            else min = minHeap.poll();
        } 
        return max[1]-min[1]; 
        */

        int n = arrays.size();
        int[][] twoMin = new int[2][2];
        twoMin[0][1] = Integer.MAX_VALUE;
        twoMin[1][1] = Integer.MAX_VALUE;
        int[][] twoMax = new int[2][2];
        twoMax[0][1] = Integer.MIN_VALUE;
        twoMax[1][1] = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(twoMin[0][1] > arrays.get(i).get(0)) {
                twoMin[1][1] = twoMin[0][1];
                twoMin[1][0] = twoMin[0][0];
                twoMin[0][1] = arrays.get(i).get(0);
                twoMin[0][0] = i;
            }
            else if(twoMin[1][1] > arrays.get(i).get(0)){
                twoMin[1][1] = arrays.get(i).get(0);
                twoMin[1][0] = i;
            }

            List<Integer> array = arrays.get(i);
            int le = array.size();

            if(twoMax[0][1] < array.get(le-1)) {
                twoMax[1][1] = twoMax[0][1];
                twoMax[1][0] = twoMax[0][0];
                twoMax[0][1] = array.get(le-1);
                twoMax[0][0] = i;
            }
            else if(twoMax[1][1] < array.get(le-1)){
                twoMax[1][1] = array.get(le-1);
                twoMax[1][0] = i;
            }

        }

        if(twoMax[0][0] == twoMin[0][0]) {
            return Math.max(twoMax[1][1]-twoMin[0][1], twoMax[0][1]-twoMin[1][1]);
        }

        return twoMax[0][1] - twoMin[0][1];
    }
}