class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<n;j++) {
                int product = nums[i]*nums[j];
                map.put(product, map.getOrDefault(product, 0)+1);
            }
        }

        System.out.println(map);

        int tuples = 0;
        for(int key : map.keySet()) {
            int value = map.get(key);
            tuples+=((value*(value-1))/2);
        }

        return tuples*8;
    }
}