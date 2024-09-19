class Solution {
    public int majorityElement(int[] nums) {
        //Bayer Moore Voting Algo
        //TC - O(N), SC - O(1)

        int majorityEle = getMajorityElement(nums);
        return majorityEle;
    }
    public int getMajorityElement(int[] nums) {
        int count = 0;
        int major = -1;
        for(int i=0;i<nums.length;i++) {
            if(count == 0) {
                major = nums[i];
                count = 1;
            }
            else {
                if(major == nums[i]) count++;
                else count--;
            }
        }
        return major;
    }
}