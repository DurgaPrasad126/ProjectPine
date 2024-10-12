class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int maxLeaving = 0;
        List<Friend> friends = new ArrayList<>();
        for(int i=0;i<times.length;i++) {
            friends.add(new Friend(times[i][0], times[i][1], i));
            maxLeaving = Math.max(maxLeaving, times[i][1]);
        }
        Collections.sort(friends, (a,b) -> a.arrived - b.arrived);

        Queue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<times.length;i++) q.offer(i);
        int res = 0;

        Queue<Friend> chairs = new PriorityQueue<>((a,b) -> a.depart-b.depart);
        int cur = 0;
        for(int i=1;i<=maxLeaving;i++) {
            while(!chairs.isEmpty() && chairs.peek().depart == i) {
                Friend leaftFrd = chairs.poll();
                q.add(leaftFrd.chairIdx);
            }
            if(cur < times.length && i == friends.get(cur).arrived) {
                Friend curFr = friends.get(cur);
                curFr.chairIdx = q.poll();
                chairs.offer(curFr);
                cur++;
                if(curFr.idx == targetFriend) {
                    res = curFr.chairIdx;
                    break;
                }
            }
        }
        return res;
    }

}

class Friend {
    int arrived;
    int depart;
    int idx;
    int chairIdx;

    public Friend(int arrive, int depart, int idx) {
        this.arrived = arrive;
        this.depart = depart;
        this.idx = idx;
    }
}