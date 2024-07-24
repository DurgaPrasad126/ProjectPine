class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {

        int n = nums.length;
        int[][] mappedNums = new int[n][2];

        for(int i=0;i<nums.length;i++){
            mappedNums[i][0] = convertNumToMappedNum(nums[i], mapping);
            mappedNums[i][1] = i;
        }

        Arrays.sort(mappedNums, (a,b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int[] mappedValues = new int[n];
        for(int i=0;i<n;i++) {
            mappedValues[i] = nums[mappedNums[i][1]];
        }

        return mappedValues;
    }

    public int convertNumToMappedNum(int num, int[] mapping){
        if(num >= 0 && num <=9) return mapping[num];
        int mappedNum = 0;
        int i=0;
        while(num > 0){
            mappedNum = ((int)Math.pow(10,i++))*mapping[num%10] + mappedNum;
            num/=10;
        }
        return mappedNum;
    }
}