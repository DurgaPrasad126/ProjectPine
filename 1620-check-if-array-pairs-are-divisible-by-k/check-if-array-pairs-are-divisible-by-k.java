class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;

        Map<Integer, Integer> remFreq = new HashMap<>();

        for(int i=0;i<n;i++) {
            int rem = ((arr[i]%k)+k)%k;
            remFreq.put((rem), remFreq.getOrDefault((rem), 0)+1);
        }

        for(int rem : remFreq.keySet()) {
            if(rem == 0) {if(remFreq.get(rem)%2 != 0) return false;}
            else if(!Objects.equals(remFreq.get(rem),remFreq.get(k-rem))){
                return false;
            }
        }
        return true;
    }
}