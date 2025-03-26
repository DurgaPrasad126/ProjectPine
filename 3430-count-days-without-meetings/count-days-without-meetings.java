class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        int noMeetingDays = meetings[0][0]-1;
        int prevEnd = meetings[0][1];

        for(int i=1;i<meetings.length;i++){
            noMeetingDays+=(meetings[i][0] > prevEnd ? meetings[i][0]-prevEnd-1 : 0);
            prevEnd = Math.max(prevEnd, meetings[i][1]);
        }

        return noMeetingDays + (days-prevEnd);
    }
}