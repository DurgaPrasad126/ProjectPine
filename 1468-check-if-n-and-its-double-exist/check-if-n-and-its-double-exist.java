class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> ele = new HashSet<>();
        for(int i : arr) {
            if(i==0) {
                if(ele.contains(i)) return true;
            }
            else {
                if((i%2==0 && ele.contains(i/2)) || ele.contains(i*2)) return true;                
            }
            ele.add(i);
        }
        return false;
    }
}