class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 1) return nums.length;
        HashSet<Integer> set = new HashSet<>();
        int maxCount = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            
        }
       
       for(int num:set){
           if(!set.contains(num-1)){
               count=1;
               int currNum = num;
               while(set.contains(currNum+1)){
                   count+=1;
                   currNum+=1;
               }
               maxCount = Math.max(count, maxCount);
           }
       }
        return maxCount;

    }
}