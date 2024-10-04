class Solution {
    public int[] arrayRankTransform(int[] arr) {
       int[] sortedArr = arr.clone();
       Arrays.sort(sortedArr);
       Map<Integer, Integer> rankMap = new HashMap<>();
       for(int i : sortedArr) rankMap.putIfAbsent(i, rankMap.size()+1);
       for(int i=0;i<arr.length;i++) {
        sortedArr[i] = rankMap.get(arr[i]);
       }
       return sortedArr;
    }
}