class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i], i);
        }

        for(int i=0;i<arr1.length-1;i++){
            for(int j=i+1;j<arr1.length;j++){
                if(!map.containsKey(arr1[i]) || !map.containsKey(arr1[j])) {
                    if(map.containsKey(arr1[j])){
                        int temp = arr1[j];
                        arr1[j] = arr1[i];
                        arr1[i] = temp;
                    }

                    if(!map.containsKey(arr1[i]) && !map.containsKey(arr1[j])) {
                        if(arr1[i] > arr1[j]) {
                            int temp = arr1[i];
                            arr1[i] = arr1[j];
                            arr1[j] = temp;
                        }
                    }
                }
                else if(map.get(arr1[i]) > map.get(arr1[j])){
                    int temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
            }
        }
        return arr1;
    }
}