class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        //Arrays.sort(seats);
        //Arrays.sort(students);

        seats = countSort(seats);
        students = countSort(students);

        int res = 0;

        for(int i=0;i<seats.length;i++){
            res+=Math.abs(seats[i]-students[i]);
        }
        return res;
    }

    private int[] countSort(int[] arr) {
        int n = arr.length;
        int[] result = new int[101];
        int pos = 0;
        for(int i=0;i<n;i++){
            result[arr[i]]++;
        }

        for(int i=0;i<101;i++) {
            while(result[i] > 0) {
                arr[pos++] = i;
                result[i]--;
            }
        }

        return arr;
    }
}