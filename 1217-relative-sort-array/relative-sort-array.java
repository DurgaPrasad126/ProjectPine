class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max =  Arrays.stream(arr1).max().orElse(0);
        int[] count  = new int[max+1];
        int[] res = new int[arr1.length];
        int pos = 0;
        for(int e :arr1) {
            count[e]++;
        }

        for(int e : arr2) {
            while(count[e] > 0) {
                res[pos++] = e;
                count[e]--;
            }
        }

        for(int i=0;i<=max;i++){
            if(count[i] > 0) {
                while(count[i] > 0) {
                    res[pos++] = i;
                    count[i]--;
                }

            }
        }
        return res;
    }
}