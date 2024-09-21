class Solution {
    public List<Integer> lexicalOrder(int n) {
        String[] numbers = new String[n];
        for(int i=1;i<=n;i++) {
            numbers[i-1] = String.valueOf(i);
        }
        Arrays.sort(numbers);
        List<Integer> nums = new ArrayList<>();
        for(int i=0;i<n;i++){
            nums.add(Integer.valueOf(numbers[i]));
        }
        return nums;

    }
}