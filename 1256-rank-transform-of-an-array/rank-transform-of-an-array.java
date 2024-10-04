class Solution {
    public int[] arrayRankTransform(int[] arr) {
        //return new int[0];
        Set<Integer> uniqueEle = new TreeSet<>();
        for(int a : arr) uniqueEle.add(a);
        List<Integer> ele = new ArrayList<>(uniqueEle);
        //Collections.sort(ele);
        Map<Integer, Integer> rankArr = new HashMap<>();

        for(int i=0;i<ele.size();i++) {
            rankArr.put(ele.get(i), i+1);
        }

        int[] rankTra = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            rankTra[i] = rankArr.get(arr[i]);
        }
        return rankTra;

    }
}