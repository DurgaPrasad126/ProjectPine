class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIdx = new int[26];
        char[] ch = s.toCharArray();
        int n = s.length();
        for(int i=0;i<n;i++){
            lastIdx[ch[i]-'a']=i;
        }
       
        int start = 0;
        int maxPartitionIdx = -1;
        List<Integer> partitions = new ArrayList<>();

        for(int i=0;i<n;i++){
            maxPartitionIdx = Math.max(maxPartitionIdx, lastIdx[ch[i]-'a']);
            if(maxPartitionIdx == i) {
                partitions.add(maxPartitionIdx-start+1);
                start = maxPartitionIdx+1;
            }
        }
        return partitions;
    }
}