class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> friends = new ArrayList<>();

        for(int i=0;i<n;i++) {
            friends.add(i+1);
        }
        int pos = 0;

        while(n != 1) {
            int positionToRemove = (pos+k-1)%(n);
            friends.remove(positionToRemove);
            pos=positionToRemove;
            n--;
        }

        return friends.get(0);
    }
}