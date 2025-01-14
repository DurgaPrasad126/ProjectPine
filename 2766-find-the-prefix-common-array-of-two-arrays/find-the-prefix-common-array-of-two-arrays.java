class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> common = new HashSet<>();
        int n = A.length;
        int[] prefixCom = new int[n];
        int i = 0;
        while(i < n) {
            prefixCom[i] = i!=0 ? prefixCom[i-1] : 0;
            if(A[i] == B[i]) {
                prefixCom[i]+=1;
                common.add(A[i]);
            }
            else{
                getCommonValue(A, i, common, prefixCom);
                getCommonValue(B, i, common, prefixCom);
            }
            i++;
        }
        return prefixCom;
    }

    public void getCommonValue(int[] arr, int i, Set<Integer> common, int[] prefixCom) {
        if(common.contains(arr[i])) prefixCom[i]+=1;
        else {
            common.add(arr[i]);
        }
    }
}