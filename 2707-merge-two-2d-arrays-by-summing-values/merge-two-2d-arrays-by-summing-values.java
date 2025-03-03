class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        Map<Integer, Integer> idVal = new TreeMap<>();
        for(int i=0;i<n1;i++){
            idVal.put(nums1[i][0], idVal.getOrDefault(nums1[i][0], 0) + nums1[i][1]);
        }
        for(int i=0;i<n2;i++){
            idVal.put(nums2[i][0], idVal.getOrDefault(nums2[i][0], 0) + nums2[i][1]);
        }

        int[][] res = new int[idVal.size()][2];
        int pos = 0;
        for(int key : idVal.keySet()) {
            res[pos++] = new int[]{key, idVal.get(key)};
        }
        return res;
    }
}