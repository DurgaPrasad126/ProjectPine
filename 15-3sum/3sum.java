class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i < n && nums[i] <= 0;i++) {
            if(i==0 || nums[i] != nums[i-1]) {
                twoSum(nums, res, i, n);
            }
        }  
        return res;
    }

    public void twoSum(int[] nums, List<List<Integer>> res, int i, int n) {
        int low = i + 1;
        int high = n-1;

        while(low < high) {
            int val = nums[i] + nums[low] + nums[high];
            if(val == 0) {
                res.add(new ArrayList<>(Arrays.asList(nums[i], nums[low++], nums[high--])));
                while(low < high && nums[low] == nums[low-1]) low++;
            }
            else if(val > 0) high--;
            else low++;
          
        }
    }
}